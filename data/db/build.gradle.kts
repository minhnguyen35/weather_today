plugins {
    id("kotlin")
    alias(libs.plugins.android.lint) apply false
}

dependencies {
    implementation(projects.base)
    api(projects.data.models)
    api(libs.androidx.paging.common)
}
