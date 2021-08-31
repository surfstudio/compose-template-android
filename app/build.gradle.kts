@file:Suppress("unchecked_cast")

apply("../gradleSrc/versions.gradle.kts")
apply("../gradleSrc/dependencies.gradle.kts")
apply("../gradleSrc/configuration.gradle.kts")

val ex = project.extra

val configurationSource: Any.() -> Unit by ex
val configurationCompose: Any.() -> Unit by ex

val compileSdkCommon: Int by ex
val targetSdkCommon: Int by ex
val minSdkCommon: Int by ex

plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")

    id("com.google.devtools.ksp")
    // https://dagger.dev/hilt/
    id("dagger.hilt.android.plugin")
    // https://github.com/Kotlin/kotlinx.serialization
    kotlin("plugin.serialization")
    // https://developers.google.com/android/guides/google-services-plugin
    id("com.google.gms.google-services")
    // https://firebase.google.com/products/crashlytics
    id("com.google.firebase.crashlytics")
    // https://github.com/ben-manes/gradle-versions-plugin
    id("com.github.ben-manes.versions")
}

android {

    compileSdk = compileSdkCommon

    defaultConfig {

        minSdk = minSdkCommon
        targetSdk = targetSdkCommon

        applicationId = "ru.surf.template"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // common configuration compose
    this.configurationCompose()

    // common configuration source
    this.sourceSets.configurationSource()

    // disable waring OptIn
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

// modules
dependencies {
    implementation(project(":modules:users"))
}

// libraries
dependencies {

    // imports dependencies
    val dependencyKtor: DependencyHandlerScope.() -> Unit by ex
    val dependencyCompose: DependencyHandlerScope.() -> Unit by ex
    val dependencyAccompanist: DependencyHandlerScope.() -> Unit by ex
    val dependencyFirebase: DependencyHandlerScope.() -> Unit by ex
    val dependencyRoom: DependencyHandlerScope.() -> Unit by ex
    val dependencyHilt: DependencyHandlerScope.() -> Unit by ex
    val dependencyOther: DependencyHandlerScope.() -> Unit by ex
    val dependencyUnitTest: DependencyHandlerScope.() -> Unit by ex
    val dependencyUITest: DependencyHandlerScope.() -> Unit by ex

    // implementation
    dependencyKtor()
    dependencyCompose()
    dependencyAccompanist()
    dependencyFirebase()
    dependencyRoom()
    dependencyHilt()
    dependencyOther()

    // test
    dependencyUnitTest()
    dependencyUITest()
}