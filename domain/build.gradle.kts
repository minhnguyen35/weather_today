plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.minhnguyen.domain"
}

dependencies {
    implementation(projects.base)
    implementation(projects.data.models)
    implementation(projects.data.forecasts)
    implementation(projects.data.syncinformation)

    implementation(libs.androidx.core)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.hilt.library)
    kapt(libs.hilt.compiler)
}