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

plugins {
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
}

apply(plugin = "org.jetbrains.dokka")

// gradlew dokkaHtmlMultiModule
tasks.withType<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>().configureEach {
    outputDirectory.set(rootDir.resolve("dokka"))
    failOnWarning.set(true)
}

subprojects {

    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "com.diffplug.spotless")

    spotless {
        kotlin {
            target("**/*.kt")
            ktlint(libs.versions.ktlint.get())
                .userData(mapOf(
                    "disabled_rules" to "no-wildcard-imports",
                ))
            licenseHeaderFile("$rootDir/copyright.txt")
        }
        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
    }

    tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
        dokkaSourceSets {
            configureEach {
                // List of files with module and package documentation
                // https://kotlinlang.org/docs/reference/kotlin-doc.html#module-and-package-documentation
                includes.from("dokka.md")
                // Disable linking to online Android documentation (only applicable for Android projects)
                noAndroidSdkLink.set(false)
                // Emit warnings about not documented members. Applies globally, also can be overridden by packageOptions
                reportUndocumented.set(false)
                // Do not output deprecated members. Applies globally, can be overridden by packageOptions
                skipDeprecated.set(true)
                // Linking to online kotlin-stdlib documentation
                noStdlibLink.set(true)
                // Linking to online JDK documentation
                noJdkLink.set(true)
            }
        }
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
