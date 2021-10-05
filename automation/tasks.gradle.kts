/*
 * Automation create module
 * @see https://github.com/surfstudio/surf-compose-template-android-modules
 */
abstract class CreateModule @Inject constructor(
    private val type: String,
) : DefaultTask() {

    @get:Input
    @set:Option(option = "module", description = "Module name")
    var module = ""

    @TaskAction
    fun doWork() {
        project.exec {
            if (module.isEmpty()) {
                commandLine(
                    "echo",
                    "You must provide a name for the module: gradle moduleSimple --module={name}!"
                )
            } else {
                commandLine(
                    "java", "-jar", "${project.rootDir}/automation/modules-0.0.1-all.jar",
                    "--type", "simple",
                    "--path", project.rootDir,
                    "--name", module
                )
            }
        }
    }
}

/*
 * Task for simple module
 */
tasks.register<CreateModule>("moduleSimple", "simple")

/*
 * Task for simple module
 */
//tasks.register<CreateModule>("moduleMiddle", "middle")

/*
 * Task for simple module
 */
//tasks.register<CreateModule>("moduleLarger", "larger")