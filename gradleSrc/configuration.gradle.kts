//////////////////////////////////////////
//// Default configuration
//////////////////////////////////////////

buildscript {

    apply("${project.rootDir}/gradleSrc/versions.gradle.kts")

    val kotlinVersion: String by extra
    val gradleVersion: String by extra

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

extra["configurationSource"] = { ex: Any ->
    if (ex is NamedDomainObjectContainer<*>) {
        (ex.getByName("main") as? com.android.build.api.dsl.AndroidSourceSet)?.let { data ->
            data.res.setSrcDirs(emptySet<String>())
            file("src/main/res").listFiles()?.toList()?.forEach { dir ->
                data.res.srcDir(dir)
            }
        }
    }
}

extra["configurationCompose"] = { ex: Any ->
    if (ex is com.android.build.gradle.internal.dsl.BaseAppModuleExtension) {
        val composeVersion: String by project.extra
        ex.composeOptions {
            kotlinCompilerExtensionVersion = composeVersion
        }
        ex.buildFeatures {
            compose = true
        }
    }
}