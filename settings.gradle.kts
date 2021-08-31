pluginManagement {

    apply("gradleSrc/versions.gradle.kts")

    val gradleVersion: String by extra
    val kotlinVersion: String by extra
    val gradleVersionsPlugin: String by extra
    val kspVersion: String by extra

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        id("com.android.application") version gradleVersion
        id("com.android.library") version gradleVersion
        id("org.jetbrains.kotlin.android") version kotlinVersion
        id("com.github.ben-manes.versions") version gradleVersionsPlugin
        id("com.google.devtools.ksp") version kspVersion
        kotlin("kapt") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Template"
include(":app")

// include modules
include(":modules:users")