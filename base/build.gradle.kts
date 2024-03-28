plugins{
    id("kotlin")
    alias(libs.plugins.android.lint) apply false
}
dependencies{
    api(libs.kotlin.coroutines.core)
    api(libs.dagger.dagger)
}