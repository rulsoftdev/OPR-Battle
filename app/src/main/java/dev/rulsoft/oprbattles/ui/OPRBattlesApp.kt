package dev.rulsoft.oprbattles.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import dev.rulsoft.oprbattles.R
import dev.rulsoft.oprbattles.navigations.Navigation
import dev.rulsoft.oprbattles.navigations.composable.AppBarIcon
import dev.rulsoft.oprbattles.navigations.composable.AppBottomNavigation
import dev.rulsoft.oprbattles.ui.theme.OPRBattlesTheme

private const val TAG =  "OPRBattlesApp"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OPRBattlesApp(appState: OPRBattlesAppState = rememberOPRBattlesAppState()){

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    OPRBattlesScreen {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = appState.snackbarHostState)
            },
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(id = appState.title_screen)) },
                    navigationIcon = {
                        if (appState.showUpNavigation) {
                            AppBarIcon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription =  R.string.bottom_back,
                                onClick = {
                                    Log.d(TAG, "Back")
                                    appState.onBackClick()
                                }
                            )
                        }
                    },
                    scrollBehavior = if (appState.showUpNavigation) scrollBehavior else null
                )
            },
            bottomBar = {
                if (appState.showBottomNavigation) {
                    AppBottomNavigation(
                        bottomNavOptions = OPRBattlesAppState.BOTTOM_NAV_OPTIONS,
                        currentRoute = appState.currentRoute,
                        onNavItemClick = { appState.onNavItemClick(it) })
                }
            },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ){ padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(appState.navController, appState.snackbarHostState)
            }
        }
    }

}



@Composable
fun OPRBattlesScreen(content: @Composable () -> Unit) {
    OPRBattlesTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}