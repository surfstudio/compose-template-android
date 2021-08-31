//////////////////////////////////////////
//// Default configuration
//////////////////////////////////////////

buildscript {
    apply("${project.rootDir}/gradleSrc/buildscript.gradle.kts")
    val configurationBuildscript: ScriptHandlerScope.() -> Unit by project
    configurationBuildscript()
}


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