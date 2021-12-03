val dependenciesInternal: Any.() -> Unit by project.extra
val androidConfig: Any.() -> Unit by project.extra

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    this.androidConfig()

    // disable waring OptIn
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

// libraries
dependencies {

    // Common module for all modules
    implementation(project(":modules:core"))

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