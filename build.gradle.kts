buildscript {
    apply("${project.rootDir}/gradleSrc/buildscript.gradle.kts")
    val configurationBuildscript: ScriptHandlerScope.() -> Unit by project
    configurationBuildscript()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}