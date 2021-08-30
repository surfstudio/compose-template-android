////////////////////////////////////////////
////// Dependencies
////////////////////////////////////////////

val ex = project.extra

extra["dependencyCompose"] = {
    project.dependencies {
        "implementation".let { implementation ->
            implementation("androidx.compose.material:material:${ex["composeVersion"]}")
            implementation("androidx.compose.ui:ui:${ex["composeVersion"]}")
            implementation("androidx.compose.ui:ui-tooling-preview:${ex["composeVersion"]}")
            implementation("androidx.activity:activity-compose:${ex["activityComposeVersion"]}")
        }
    }
}