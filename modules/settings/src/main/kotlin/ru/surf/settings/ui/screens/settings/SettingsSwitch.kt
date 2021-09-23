package ru.surf.settings.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.keygenqt.modifier.paddingLarge

@Composable
fun SettingsSwitch(
    text: String,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    var checkedState: Boolean by remember { mutableStateOf(checked) }

    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                checkedState = !checkedState
                onCheckedChange(checkedState)
            })
    ) {
        ConstraintLayout(
            modifier = Modifier.paddingLarge()
        ) {
            val (vText, switch) = createRefs()

            Text(
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1,
                text = text,
                modifier = Modifier
                    .defaultMinSize(minWidth = 100.dp)
                    .constrainAs(vText) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Switch(
                checked = checkedState,
                onCheckedChange = {
                    checkedState = !checkedState
                    onCheckedChange.invoke(checked)
                },
                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.secondary),
                modifier = Modifier
                    .constrainAs(switch) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}