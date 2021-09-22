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
    // Connecting internal libraries
    extra["dependenciesInternal"] = { ex: Any ->
        "implementation".let { implementation ->
            (ex as? DependencyHandlerScope)?.apply {
                if (findProperty("internalLibrariesEnable").toString().toBoolean()) {
                    implementation(project(":android-response-result"))
                    implementation(project(":compose-forms"))
                    implementation(project(":compose-modifier-ext"))
                    implementation(project(":compose-routing"))
                    implementation(project(":surf-accompanist"))
                } else {
                    implementation(libs.bundles.surf)
                }
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}