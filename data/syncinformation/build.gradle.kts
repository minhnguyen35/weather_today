plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.minhnguyen.syncinformation"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(projects.data.db)
    api(projects.base)
    api(projects.data.legacy)
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
    api(libs.hilt.library)
    kapt(libs.hilt.compiler)
}