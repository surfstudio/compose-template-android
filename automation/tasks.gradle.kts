/*
 * Add simple module
 * @see https://github.com/surfstudio/surf-compose-template-android-modules
 */
task<Exec>("moduleSimple") {

    try {
        val name: String = this.args!![0]!!

        workingDir("$projectDir")

        commandLine(
            "java",
            "-jar",
            "$rootDir/automation/modules-0.0.1-all.jar",
            "--path",
            "$projectDir",
            "--name",
            name
        )
    } catch (ex: Exception) {
        println(ex)
    }
}