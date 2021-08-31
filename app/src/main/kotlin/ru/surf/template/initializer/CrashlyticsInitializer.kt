@file:Suppress("unused")

package ru.surf.template.initializer

import android.content.Context
import androidx.startup.Initializer
import com.google.firebase.crashlytics.FirebaseCrashlytics
import ru.surf.template.BuildConfig

class CrashlyticsInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
