package dev.rulsoft.oprbattles.navigations

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import dev.rulsoft.oprbattles.ui.screen.club.ClubDetailScreen
import dev.rulsoft.oprbattles.ui.screen.club.ClubDetailViewModel
import dev.rulsoft.oprbattles.ui.screen.club.ClubListScreen

private const val TAG = "Navigation"


@Composable fun Navigation(navController: NavHostController, snackbarHostState: SnackbarHostState) {

    val navGraph =  remember(navController){
        navController.createGraph(startDestination = NavItem.ClubList.route){
            composable(NavItem.ClubList) {
                ClubListScreen { clubItem ->
                    navController.navigate(NavItem.ClubDetail.createNavRoute(clubItem.uid))
                }
            }
            composable(NavItem.ClubDetail) { backStackEntry ->
                ClubDetailScreen(
                    viewModel {
                        ClubDetailViewModel(backStackEntry.findArg(NavArg.ClubId, "El uid del club es obligatorio"))
                    }
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
    NavHost(
        navController = navController,
        graph = navGraph
    )
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
){
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg, message: String = "Error required") : T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}