import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.minhnguyen.weather.network"
    buildFeatures{
        buildConfig = true
    }
    testOptions{
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    defaultConfig {
        val properties = gradleLocalProperties(rootDir)
        buildConfigField("Boolean", "DEBUG", "\"" + properties.getProperty("DEBUG", "true") + "\"")
        buildConfigField("String", "HOST", "\"" + properties.getProperty("BACK_END_URL", "") + "\"")
        buildConfigField("String", "API_KEY", "\"" + properties.getProperty("OPEN_WEATHER_KEY", "") + "\"")
    }
}

dependencies {
    implementation(projects.base)
    implementation(libs.okhttp.okhttp)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    api(libs.hilt.library)
    kapt(libs.hilt.compiler)
}