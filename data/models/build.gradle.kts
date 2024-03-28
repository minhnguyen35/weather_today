plugins {
    id("kotlin")
    alias(libs.plugins.android.lint) apply false
}

dependencies {
    api(projects.base)
    api(libs.androidx.room.common) // Room annotations
    api("org.threeten:threetenbp:${libs.versions.threetenbp.get()}:no-tzdb")
}