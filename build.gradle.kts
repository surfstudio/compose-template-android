buildscript {

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

allprojects {
    // Configurations Source
    extra["configurationSource"] = { ex: Any ->
        if (ex is NamedDomainObjectContainer<*>) {
            (ex.getByName("main") as? com.android.build.gradle.internal.api.DefaultAndroidSourceSet)?.let { data ->
                data.res.setSrcDirs(emptySet<String>())
                file("src/main/res").listFiles()?.toList()?.forEach { dir ->
                    data.res.srcDir(dir)
                }
            }
        }
    }
    // Configurations Compose
    extra["configurationCompose"] = { ex: Any ->
        val composeVersion = findProperty("composeVersion").toString()
        if (ex is com.android.build.gradle.internal.dsl.BaseAppModuleExtension) {
            ex.composeOptions {
                kotlinCompilerExtensionVersion = composeVersion
            }
            ex.buildFeatures {
                compose = true
            }
        }
        if (ex is com.android.build.gradle.LibraryExtension) {
            ex.composeOptions {
                kotlinCompilerExtensionVersion = composeVersion
            }
            ex.buildFeatures {
                compose = true
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}