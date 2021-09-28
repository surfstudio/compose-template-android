/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
@file:Suppress("unused")

package ru.surf.core.initializer

import android.content.Context
import androidx.startup.Initializer
import com.keygenqt.modifier.ModifierConfiguration
import ru.surf.core.BuildConfig
import timber.log.Timber

/**
 * Initialization [Timber]
 *
 * @author Vitaliy Zarubin
 */
class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
