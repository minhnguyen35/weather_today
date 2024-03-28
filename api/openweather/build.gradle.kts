plugins {
    id("kotlin")
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.hilt) apply false
}

dependencies {
    implementation(projects.base)
    implementation(libs.okhttp.okhttp)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    api(libs.openWeather)
    kapt(libs.dagger.compiler)
    kapt(libs.hilt.compiler)
}