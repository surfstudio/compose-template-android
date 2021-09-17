val configurationSource: Any.() -> Unit by project.extra

plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")

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

    compileSdk = findProperty("compileSdk").toString().toInt()

    defaultConfig {

        minSdk = findProperty("minSdk").toString().toInt()
        targetSdk = findProperty("targetSdk").toString().toInt()

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

    composeOptions {
        kotlinCompilerExtensionVersion = findProperty("composeVersion").toString()
    }

    buildFeatures {
        compose = true
    }

    // common configuration source
    this.sourceSets.configurationSource()

    // disable waring OptIn
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

// modules
dependencies {
    implementation(project(":modules:core"))
    implementation(project(":modules:other"))
    implementation(project(":modules:users"))
}

// libraries
dependencies {

    implementation(libs.bundles.surf)
    implementation(libs.bundles.room)
    implementation(libs.bundles.paging)
    implementation(libs.bundles.other)
    implementation(libs.bundles.lottie)
    implementation(libs.bundles.retrofit2)
    implementation(libs.bundles.firebase)
    implementation(libs.bundles.coil)
    implementation(libs.bundles.accompanist)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.hilt)

    kapt(libs.bundles.hiltKapt)
    kapt(libs.bundles.roomKapt)

    testImplementation(libs.bundles.test)
    debugImplementation(libs.bundles.testDebug)
    androidTestImplementation(libs.bundles.testAndroid)
}