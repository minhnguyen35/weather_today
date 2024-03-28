@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.cacheFixPlugin)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.dbroom"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.base)
    implementation(libs.core.ktx)
    api(libs.androidx.room.runtime)
    api(libs.androidx.room.ktx)
    api(libs.androidx.room.paging)
    ksp(libs.androidx.room.compiler)
    api(projects.data.db)
    implementation(libs.hilt.library)
    kapt(libs.hilt.compiler)
}