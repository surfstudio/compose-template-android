buildscript {

    val kotlinVersion: String by project
    val gradleVersion: String by project
    val hiltCoreVersion: String by project
    val googleServicesVersion: String by project
    val crashlyticsPluginVersion: String by project
    val appDistribution: String by project

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
        classpath("com.google.firebase:firebase-appdistribution-gradle:$appDistribution")
    }
}

plugins {
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
}

apply(from = "automation/tasks.gradle.kts")

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
            targetExclude("**/build/**")
            ktlint(libs.versions.ktlint.get())
                .userData(
                    mapOf(
                        "disabled_rules" to "no-wildcard-imports",
                    )
                )
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

        // Suppress all inherited members that were not overriden in a given class.
        suppressInheritedMembers.set(true)

        dokkaSourceSets {
            configureEach {
                // List of files with module and package documentation
                // https://kotlinlang.org/docs/reference/kotlin-doc.html#module-and-package-documentation
                includes.from("dokka.md")
                // Use to include or exclude non public members
                includeNonPublic.set(true)
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

        val implementation = "implementation"

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
    // Android
    extra["androidConfig"] = { ex: Any ->
        (ex as? com.android.build.gradle.LibraryExtension)?.apply {

            val configurationSource: Any.() -> Unit by project.extra

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
                debug {
                    isMinifyEnabled = false
                }
                create("qa") {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "$rootDir/proguard-rules.pro"
                    )
                }
                release {
                    isMinifyEnabled = true
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
            sourceSets.configurationSource()

            packagingOptions {
                resources {
                    excludes.add("META-INF/licenses/**")
                    excludes.add("META-INF/AL2.0")
                    excludes.add("META-INF/LGPL2.1")
                }
            }
        }
    }
}
