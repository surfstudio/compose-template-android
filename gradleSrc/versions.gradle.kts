//////////////////////////////////////////
//// Versions
//////////////////////////////////////////

// buildscript
extra["configurationBuildscript"] = { scope: ScriptHandlerScope ->
    scope.apply {
        repositories {
            google()
            mavenCentral()
        }
        dependencies {
            classpath("com.android.tools.build:gradle:7.0.1")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
            classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
            classpath("com.google.gms:google-services:4.3.10")
            classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
        }
    }
}

// android
extra["compileSdkCommon"] = 31
extra["targetSdkCommon"] = 31
extra["minSdkCommon"] = 23

// base
extra["kotlinVersion"] = "1.5.10"
extra["gradleVersion"] = "7.0.1"

// ktor
extra["ktorVersion"] = "1.6.3"

// accompanist
extra["accompanistVersion"] = "0.17.0"

// firebase
extra["googleServicesVersion"] = "4.3.10"
extra["firebaseBomVersion"] = "28.4.0"
extra["crashlyticsPluginVersion"] = "2.7.1"

// room
extra["roomVersion"] = "2.3.0"

// compose
extra["composeVersion"] = "1.0.0"
extra["activityComposeVersion"] = "1.3.0"

// hilt
extra["hiltCoreVersion"] = "2.38.1"
extra["hiltVersion"] = "1.0.0"
extra["hiltComposeNavigationVersion"] = "1.0.0-alpha03"

// other
extra["timberVersion"] = "5.0.1"
extra["startupVersion"] = "1.1.0"

// unit test
extra["mockWebServerVersion"] = "4.9.1"
extra["mockitoCoreVersion"] = "3.10.0"
extra["gradleVersionsPlugin"] = "0.39.0"