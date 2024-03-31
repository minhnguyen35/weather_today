plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.cacheFixPlugin)
}

android {
    namespace = "com.example.weathertoday.legacy.inject"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.base)
    implementation(libs.hilt.library)
    api(projects.data.forecasts)
    api(projects.data.db)
    
    kapt(libs.hilt.compiler)
}