import com.android.build.gradle.BaseExtension
import com.android.build.gradle.BasePlugin
import dagger.hilt.android.plugin.HiltExtension
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.cacheFixPlugin) apply false
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.gms.googleServices) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.spotless) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()

        // Need to use the 'dev' Compose Compiler for Kotlin 1.8.0 support
        // maven("https://androidx.dev/storage/compose-compiler/repository/")

        // Jetpack Compose SNAPSHOTs if needed
        // maven("https://androidx.dev/snapshots/builds/$composeSnapshot/artifacts/repository/")

        // Used for snapshots if needed
        // maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    // Configure Java to use our chosen language level. Kotlin will automatically
    // pick this up
    plugins.withType<JavaBasePlugin>().configureEach {
        extensions.configure<JavaPluginExtension> {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(11))
            }
        }
    }

    tasks.withType<KotlinCompilationTask<*>>().configureEach {
        compilerOptions {
            // Treat all Kotlin warnings as errors
            allWarningsAsErrors.set(true)

            // Enable experimental coroutines APIs, including Flow
            freeCompilerArgs.addAll(
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-opt-in=kotlinx.coroutines.FlowPreview",
            )

            if (project.hasProperty("tivi.enableComposeCompilerReports")) {
                freeCompilerArgs.addAll(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
                            project.buildDir.absolutePath + "/compose_metrics",
                )
                freeCompilerArgs.addAll(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
                            project.buildDir.absolutePath + "/compose_metrics",
                )
            }
        }
    }

    // Configure Hilt + Dagger
    plugins.withId(rootProject.libs.plugins.hilt.get().pluginId) {
        extensions.getByType<HiltExtension>().enableAggregatingTask = true
    }
    plugins.withId(rootProject.libs.plugins.kotlin.kapt.get().pluginId) {
        extensions.getByType<KaptExtension>().correctErrorTypes = true
    }

    // Configure Android projects
    plugins.withType<BasePlugin>().configureEach {
        extensions.configure<BaseExtension> {
            compileSdkVersion(libs.versions.compileSdk.get().toInt())
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                targetSdk = libs.versions.targetSdk.get().toInt()
            }

            // Can remove this once https://issuetracker.google.com/issues/260059413 is fixed.
            // See https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }
    }
}
