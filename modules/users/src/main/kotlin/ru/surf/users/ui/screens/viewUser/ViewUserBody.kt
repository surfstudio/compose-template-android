package ru.surf.users.ui.screens.viewUser

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.sizeLarge
import ru.surf.core.compose.Loader
import ru.surf.core.compose.LoaderPage
import ru.surf.core.compose.PageNotFound
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.users.data.mock.userModelMock
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ViewUserActions

@Composable
fun ViewUserBody(
    id: String,
    model: UserModel?,
    loading: Boolean = false,
    error404: Boolean = false,
    onActions: (ViewUserActions) -> Unit = {},
    backDispatcher: OnBackPressedDispatcher? = null
) {
    MainScaffoldSearch(
        contentTitle = {
            TopBarContentTitle(model?.name ?: "")
        },
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = {
            backDispatcher?.onBackPressed()
        },
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(loading),
            onRefresh = {
                onActions(ViewUserActions.RefreshView(id))
            },
            indicator = { st, tr ->
                SwipeRefreshIndicator(
                    state = st,
                    refreshTriggerDistance = tr,
                    contentColor = MaterialTheme.colors.onPrimary,
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                if (model is UserModel && !loading) {
                    Column(
                        modifier = Modifier
                            .paddingLarge()
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            style = MaterialTheme.typography.h6,
                            text = "User name:"
                        )

                        Spacer(modifier = Modifier.sizeLarge())

                        Text(
                            style = MaterialTheme.typography.h5,
                            text = model.name
                        )
                    }
                }
            }
            if (loading) {
                LoaderPage()
            }
            if (error404) {
                PageNotFound()
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            ViewUserBody(
                id = userModelMock().id,
                model = userModelMock()
            )
        }
    }
}