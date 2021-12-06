pluginManagement {

    val gradleVersionsPlugin: String by settings
    val artifactoryVersions: String by settings
    val spotlessVersions: String by settings
    val dokkaVersions: String by settings
    val gradleVersion: String by settings
    val kotlinVersion: String by settings

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.android") version kotlinVersion
        id("com.android.application") version gradleVersion
        id("com.android.library") version gradleVersion

        kotlin("kapt") version kotlinVersion

        // https://github.com/Kotlin/kotlinx.serialization
        kotlin("plugin.serialization") version kotlinVersion
        // https://github.com/ben-manes/gradle-versions-plugin
        id("com.github.ben-manes.versions") version gradleVersionsPlugin
        // https://www.jfrog.com/confluence/display/JFROG/Gradle+Artifactory+Plugin
        id("com.jfrog.artifactory") version artifactoryVersions
        // https://github.com/diffplug/spotless
        id("com.diffplug.spotless") version spotlessVersions
        // https://github.com/Kotlin/dokka
        id("org.jetbrains.dokka") version dokkaVersions
    }
}

// https://docs.gradle.org/current/userguide/platforms.html#sub:central-declaration-of-dependencies
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven("https://artifactory.surfstudio.ru/artifactory/libs-release-local")
    }
    versionCatalogs {
        create("libs") {
            from(fileTree("dependencies"))
        }
    }
}

val internalLibrariesEnable: String by settings

rootProject.name = "Template"
include(":app")

// Include modules app
include(":modules:core")
include(":modules:other")
include(":modules:users")
include(":modules:settings")

// Include internal libraries
// create a folder "libs" next to the application and pull libs projects there
// access for ./gradlew :{module}:artifactoryPublish - keygenqt@gmail.com || zarubin@surfstudio.ru
if (internalLibrariesEnable.toBoolean()) {
    // git@github.com:surfstudio/surf-android-response-result.git
    include(":android-response-result")
    project(":android-response-result").projectDir =
        File(settingsDir, "../libs/android-response-result")

    // git@github.com:surfstudio/surf-compose-forms.git
    include(":compose-forms")
    project(":compose-forms").projectDir = File(settingsDir, "../libs/compose-forms")

    // git@github.com:surfstudio/surf-compose-modifier-ext.git
    include(":compose-modifier-ext")
    project(":compose-modifier-ext").projectDir = File(settingsDir, "../libs/compose-modifier-ext")

    // git@github.com:surfstudio/surf-compose-routing.git
    include(":compose-routing")
    project(":compose-routing").projectDir = File(settingsDir, "../libs/compose-routing")

    // git@github.com:surfstudio/surf-accompanist.git
    include(":surf-accompanist")
    project(":surf-accompanist").projectDir = File(settingsDir, "../libs/surf-accompanist")
}