plugins{
    id("kotlin")
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.kotlin.kapt)
}

dependencies {
    api(projects.data.models)
    implementation(projects.data.db)
    implementation(projects.api.openweather)
    implementation(libs.retrofit.retrofit)
    implementation(libs.dagger.dagger)
    implementation(projects.data.legacy)
    implementation(libs.dagger.dagger)
    implementation(libs.okhttp.okhttp)
    kapt(libs.dagger.compiler)
}