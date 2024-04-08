pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "WeatherToday"
include(":base")
include(":app")
include(":ui:myui")
include(":data:db")
include(":data:models")
include(":data:inject")
include(":data:legacy")
include(":data:dbroom")
include(":core:network")
include(":data:forecasts")
include(":ui:citylist")
include(":ui:settings")
