import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.weathertoday"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weathertoday"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        val properties = gradleLocalProperties(rootDir)
//        buildConfigField("String", "API_KEY", "\"" + propOrDef("OPEN_WEATHER_KEY", "") + "\"")
//        buildConfigField("String", "HOST", "\"" + propOrDef("BACK_END_URL", "") + "\"")

        buildConfigField("String", "API_KEY", properties.getProperty("API_KEY", ""))
        buildConfigField("String", "HOST", properties.getProperty("URL", ""))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }
    packaging {
        resources {
            excludes += setOf(
                // Exclude AndroidX version files
                "META-INF/*.version",
                // Exclude consumer proguard files
                "META-INF/proguard/*",
                // Exclude the Firebase/Fabric/other random properties files
                "/*.properties",
                "fabric/*.properties",
                "META-INF/*.properties",
                "META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",
            )
        }
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(projects.base)
    implementation(projects.api.openweather)
    implementation(projects.ui.myui)
    implementation(projects.data.inject)
    implementation(projects.data.dbroom)

    implementation(libs.hilt.library)
    implementation(libs.androidx.hilt.navigationcompose)
    kapt(libs.hilt.compiler)
}

fun <T : Any> propOrDef(propertyName: String, defaultValue: T): T {
    @Suppress("UNCHECKED_CAST")
    val propertyValue = project.properties[propertyName] as T?
    return propertyValue ?: defaultValue
}
