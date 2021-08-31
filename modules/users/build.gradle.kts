@file:Suppress("unchecked_cast")

apply("../../gradleSrc/versions.gradle.kts")
apply("../../gradleSrc/dependencies.gradle.kts")
apply("../../gradleSrc/configuration.gradle.kts")

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
    val dependencyLottie: DependencyHandlerScope.() -> Unit by ex
    val dependencyPaging: DependencyHandlerScope.() -> Unit by ex
    val dependencyCoil: DependencyHandlerScope.() -> Unit by ex
    val dependencyKtor: DependencyHandlerScope.() -> Unit by ex
    val dependencyCompose: DependencyHandlerScope.() -> Unit by ex
    val dependencyAccompanist: DependencyHandlerScope.() -> Unit by ex
    val dependencyFirebase: DependencyHandlerScope.() -> Unit by ex
    val dependencyRoom: DependencyHandlerScope.() -> Unit by ex
    val dependencyHilt: DependencyHandlerScope.() -> Unit by ex
    val dependencyOther: DependencyHandlerScope.() -> Unit by ex

    // implementation
    dependencyLottie()
    dependencyPaging()
    dependencyCoil()
    dependencyKtor()
    dependencyCompose()
    dependencyAccompanist()
    dependencyFirebase()
    dependencyRoom()
    dependencyHilt()
    dependencyOther()
}