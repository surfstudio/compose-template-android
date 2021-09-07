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
        id("com.jfrog.artifactory") version "4.24.16"
        id("com.diffplug.spotless") version "5.12.5"
    }
}

// https://docs.gradle.org/current/userguide/platforms.html#sub:central-declaration-of-dependencies
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven("https://artifactory.keygenqt.com/artifactory/open-source")
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

// include libs
//include(":android-response-result")
//project(":android-response-result").projectDir = File(settingsDir, "../libs/android-response-result")

//include(":compose-forms")
//project(":compose-forms").projectDir = File(settingsDir, "../libs/compose-forms")
//
//include(":compose-modifier-ext")
//project(":compose-modifier-ext").projectDir = File(settingsDir, "../libs/compose-modifier-ext")
//
//include(":compose-routing")
//project(":compose-routing").projectDir = File(settingsDir, "../libs/compose-routing")
//
//include(":surf-accompanist")
//project(":surf-accompanist").projectDir = File(settingsDir, "../libs/surf-accompanist")