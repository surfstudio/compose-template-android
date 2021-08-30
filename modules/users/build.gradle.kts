@file:Suppress("unchecked_cast")

apply("../../gradleSrc/versions.gradle.kts")
apply("../../gradleSrc/configuration.gradle.kts")
apply("../../gradleSrc/dependencies.gradle.kts")

val ex = project.extra

val configurationSource: Any.() -> Unit by ex
val configurationCompose: Any.() -> Unit by ex

val compileSdkCommon: Int by ex
val targetSdkCommon: Int by ex
val minSdkCommon: Int by ex

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {

    compileSdk = compileSdkCommon

    defaultConfig {

        minSdk = minSdkCommon
        targetSdk = targetSdkCommon

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

dependencies {
    // imports dependencies
    val dependencyCompose: () -> Unit by ex

    // implementation
    dependencyCompose()
}