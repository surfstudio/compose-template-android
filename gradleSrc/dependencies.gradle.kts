////////////////////////////////////////////
////// Dependencies
////////////////////////////////////////////

val extra = mutableMapOf<String, DependencyHandlerScope.() -> Unit>()

// Lottie
// https://github.com/airbnb/lottie/blob/master/android-compose.md
extra["dependencyLottie"] = {

    val lottieVersions: String by ex

    implementation("com.airbnb.android:lottie:$lottieVersions")
    implementation("com.airbnb.android:lottie-compose:$lottieVersions")
}

// Paging
// https://developer.android.com/jetpack/androidx/releases/paging
extra["dependencyPaging"] = {

    val pagingComposeVersion: String by ex

    implementation("androidx.paging:paging-compose:$pagingComposeVersion")
}

// Coil
// https://coil-kt.github.io/coil/compose/
extra["dependencyCoil"] = {

    val coilVersion: String by ex
    val appcompatVersion: String by ex

    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
}

// Ktor Client
// https://ktor.io/docs/client.html
extra["dependencyKtor"] = {

    val ktorVersion: String by ex

    implementation("io.ktor:ktor-client-websockets:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
}

// Jetpack Compose
// https://developer.android.com/jetpack/compose
extra["dependencyCompose"] = {

    val composeVersion: String by ex
    val activityComposeVersion: String by ex

    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
}

// Accompanist
// https://github.com/google/accompanist
extra["dependencyAccompanist"] = {

    val accompanistVersion: String by ex

    implementation("com.google.accompanist:accompanist-insets:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanistVersion")
}

// Firebase
// https://firebase.google.com
extra["dependencyFirebase"] = {

    val firebaseBomVersion: String by ex

    implementation(platform("com.google.firebase:firebase-bom:$firebaseBomVersion"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
}

// Database Room
// https://developer.android.com/training/data-storage/room
extra["dependencyRoom"] = {

    val roomVersion: String by ex

    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
}

// Hilt
// https://dagger.dev/hilt/
extra["dependencyHilt"] = {

    val hiltCoreVersion: String by ex
    val hiltVersion: String by ex
    val hiltComposeNavigationVersion: String by ex

    implementation("com.google.dagger:hilt-android:$hiltCoreVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltCoreVersion")
    kapt("androidx.hilt:hilt-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltComposeNavigationVersion")
}

// Other
extra["dependencyOther"] = {

    val timberVersion: String by ex
    val startupVersion: String by ex

    // Timber
    // https://github.com/JakeWharton/timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Startup
    // https://developer.android.com/jetpack/androidx/releases/startup
    implementation("androidx.startup:startup-runtime:$startupVersion")
}

// Unit Test
extra["dependencyUnitTest"] = {

    val mockWebServerVersion: String by ex
    val mockitoCoreVersion: String by ex

    testImplementation("junit:junit:4.+")
    testImplementation("com.squareup.okhttp3:mockwebserver:$mockWebServerVersion")
    testImplementation("org.mockito:mockito-core:$mockitoCoreVersion")
}

// UI Test
extra["dependencyUITest"] = {

    val composeVersion: String by ex

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}

// add to project extra
extra.forEach { project.extra[it.key] = it.value }

// override
val androidTestImplementation = "androidTestImplementation"
val debugImplementation = "debugImplementation"
val testImplementation = "testImplementation"
val implementation = "implementation"
val kapt = "kapt"
val ksp = "ksp"

val ex = project.extra