/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")

package ru.surf.core.initializer

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.startup.Initializer
import ru.surfstudio.compose.modifier.SpaceConfiguration
import ru.surfstudio.compose.modifier.SpaceSize

/**
 * Initialization [SpaceConfiguration]
 *
 * @author Vitaliy Zarubin
 */
class ModifierInitializer : Initializer<Unit> {

    override fun create(context: Context) {

        // const sizes in SpaceSize
        SpaceSize.spaceThin // 2.dp
        SpaceSize.spaceSmall // 4.dp
        SpaceSize.spaceBase // 8.dp
        SpaceSize.spaceMedium // 16.dp
        SpaceSize.spaceLarge // 24.dp

        // configuration sizes in SpaceSize default
        SpaceSize.spacePageVertical // 16.dp
        SpaceSize.spacePageHorizontal // 16.dp
        SpaceSize.spaceItemVertical // 8.dp
        SpaceSize.spaceItemHorizontal // 8.dp
        SpaceSize.spaceList // 8.dp
        SpaceSize.spaceForm // 16.dp

        SpaceConfiguration.init(
            // app page top & bottom
            spacePageVertical = 16.dp,
            // app page start & and
            spacePageHorizontal = 16.dp,
            // item in list application top & bottom
            spaceItemVertical = 8.dp,
            // item in list application start & and
            spaceItemHorizontal = 8.dp,
            // item space between items in list
            spaceList = 8.dp,
            // space from inputs and other block in form
            spaceForm = 16.dp,
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
