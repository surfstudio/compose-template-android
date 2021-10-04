/*
 * Add simple module
 * @see https://github.com/surfstudio/surf-compose-template-android-modules
 */
task<Exec>("moduleSimple") {
    workingDir("$projectDir")
    commandLine("java", "-jar", "$rootDir/automation/modules-0.0.1-all.jar", "--name", "test")
}