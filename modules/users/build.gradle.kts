val configurationSource: Any.() -> Unit by project.extra
val dependenciesInternal: Any.() -> Unit by project.extra

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {

    compileSdk = findProperty("compileSdk").toString().toInt()

    defaultConfig {

        minSdk = findProperty("minSdk").toString().toInt()
        targetSdk = findProperty("targetSdk").toString().toInt()

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
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    buildFeatures {
        compose = true
    }

    // common configuration source
    this.sourceSets.configurationSource()

    android.sourceSets {
        sourceSets {

            println(this.names)

            getByName("test").java.srcDir("$projectDir/modules/core/src")
        }
    }

    // disable waring OptIn
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    packagingOptions {
        resources {
            excludes.add("**/attach_hotspot_windows.dll")
            excludes.add("META-INF/licenses/**")
            excludes.add("META-INF/AL2.0")
            excludes.add("META-INF/LGPL2.1")
        }
    }
}

// libraries
dependencies {

    // Common module for all modules
    implementation(project(":modules:core"))
    testImplementation(project(":modules:core"))

    // Connecting internal libraries
    dependenciesInternal()

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