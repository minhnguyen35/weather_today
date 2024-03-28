plugins {
    id("kotlin")
    alias(libs.plugins.android.lint) apply false
}

dependencies {
    api(projects.base)
    api(projects.api.openweather)
    api(projects.data.models)
    implementation(projects.data.db)

    implementation(libs.retrofit.retrofit)

    api(libs.store)

    api("org.threeten:threetenbp:${libs.versions.threetenbp.get()}:no-tzdb")
}