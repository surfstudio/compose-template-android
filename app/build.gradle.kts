apply("../versions.gradle.kts")

val ex = project.extra

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {

    compileSdk = 31

    defaultConfig {

        applicationId = "ru.surf.template"

        minSdk = 26
        targetSdk = 31
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "${ex["composeVersion"]}"
    }
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
    sourceSets {
        getByName("main").let { data ->
            data.res.setSrcDirs(emptySet<String>())
            file("src/main/res").listFiles()?.toList()?.forEach { dir ->
                data.res.srcDir(dir)
            }
        }
    }
}

dependencies {
    // compose
    implementation("androidx.compose.material:material:${ex["composeVersion"]}")
    implementation("androidx.compose.ui:ui:${ex["composeVersion"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${ex["composeVersion"]}")
    implementation("androidx.activity:activity-compose:${ex["activityComposeVersion"]}")
}