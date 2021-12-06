import java.io.FileInputStream
import java.util.Properties

val configurationSource: Any.() -> Unit by project.extra
val dependenciesInternal: Any.() -> Unit by project.extra

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
    // https://firebase.google.com/docs/app-distribution/android/distribute-gradle
    id("com.google.firebase.appdistribution")
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

    signingConfigs {
        create("release") {
            val storePassword = System.getenv("storePassword")
            val keyPassword = System.getenv("storePassword")
            val keyAlias = System.getenv("keyAlias")
            var storeFile = System.getenv("storeFile")

            val releaseKeystorePropsFile =
                rootProject.file("keystore/keystore_release.properties")
            if (releaseKeystorePropsFile.exists()) {
                println("Start extract release keystore config from keystore_release.properties")
                val keystoreProps = Properties()
                keystoreProps.load(FileInputStream(releaseKeystorePropsFile))
            } else {
                println("Start extract release keystore config from global vars")
            }
            if (storeFile.isNullOrBlank()) {
                storeFile = "no_keystore_file" //fix crash file(storeFile)
            }
            println("Extracted keystore config: $storePassword, $keyPassword, $keyAlias, $storeFile")

            this.keyAlias = keyAlias
            this.keyPassword = keyPassword
            this.storeFile = file(storeFile)
            this.storePassword = storePassword
        }

        create("qa") {
            storeFile = file("../keystore/test.keystore")
            storePassword = "qatest"
            keyAlias = "test"
            keyPassword = "qatest"
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "Template Debug")
        }
        create("qa") {
            isMinifyEnabled = true
            isDebuggable = true
            signingConfig = signingConfigs["qa"]
            applicationIdSuffix = ".qa"
            resValue("string", "app_name", "Template Qa")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "$rootDir/proguard-rules.pro"
            )
            firebaseAppDistribution {
                groups = "Surf"
            }
        }
        release {
            isMinifyEnabled = true
            isDebuggable = false
            signingConfig = signingConfigs["release"]
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "$rootDir/proguard-rules.pro"
            )
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

    // disable waring OptIn
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    packagingOptions {
        resources {
            excludes.add("META-INF/AL2.0")
            excludes.add("META-INF/LGPL2.1")
        }
    }
}

// modules
dependencies {
    implementation(project(":modules:core"))
    implementation(project(":modules:other"))
    implementation(project(":modules:users"))
    implementation(project(":modules:settings"))
}

// libraries
dependencies {

    dependencies {
        dokkaGfmPlugin("org.jetbrains.dokka:android-documentation-plugin:${properties["dokkaVersions"]}")
    }

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