//////////////////////////////////////////
//// buildscript
//////////////////////////////////////////

extra["configurationBuildscript"] = { scope: ScriptHandlerScope ->
    scope.apply {

        apply("${project.rootDir}/gradleSrc/versions.gradle.kts")

        val kotlinVersion: String by project
        val gradleVersion: String by project
        val hiltCoreVersion: String by project
        val googleServicesVersion: String by project
        val crashlyticsPluginVersion: String by project

        repositories {
            google()
            mavenCentral()
        }

        dependencies {
            classpath("com.android.tools.build:gradle:$gradleVersion")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
            classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltCoreVersion")
            classpath("com.google.gms:google-services:$googleServicesVersion")
            classpath("com.google.firebase:firebase-crashlytics-gradle:$crashlyticsPluginVersion")
        }
    }
}