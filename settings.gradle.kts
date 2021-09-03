

pluginManagement {

    val gradleVersion: String by settings
    val kotlinVersion: String by settings
    val gradleVersionsPlugin: String by settings

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        id("com.android.application") version gradleVersion
        id("com.android.library") version gradleVersion
        id("org.jetbrains.kotlin.android") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("com.github.ben-manes.versions") version gradleVersionsPlugin
    }
}

// https://docs.gradle.org/current/userguide/platforms.html#sub:central-declaration-of-dependencies
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(fileTree("dependencies"))
        }
    }
}

rootProject.name = "Template"
include(":app")

// include modules
include(":modules:users")