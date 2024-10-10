package dev.rulsoft.oprbattles.ui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.rulsoft.oprbattles.R
import dev.rulsoft.oprbattles.navigations.NavItem
import kotlinx.coroutines.CoroutineScope

private const val TAG = "OPRBattlesAppState"

@Composable
fun rememberOPRBattlesAppState(
    scaffoldState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): OPRBattlesAppState =  remember(snackbarHostState, navController, coroutineScope){
    OPRBattlesAppState(scaffoldState, snackbarHostState, navController, coroutineScope)
}

class OPRBattlesAppState(
    val scaffoldState: DrawerState,
    val snackbarHostState: SnackbarHostState,
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
){

    val title_screen : Int  //TODO: Ocasional hay que pensar como gestionar los titulos de las bars en funcion de currentRoute
        @Composable get() = when(currentRoute) {
            NavItem.ClubList.route -> NavItem.ClubList.title
            NavItem.ClubDetail.route -> NavItem.ClubDetail.title
            else -> R.string.app_title
        }

    val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    //TODO: Temporal hasta que implemente la navegación con grafos ya que esto no es escalable
    val showUpNavigation: Boolean
        @Composable get() = currentRoute.isNotEmpty() && currentRoute != NavItem.ClubList.route

    fun onBackClick() {
        navController.popBackStack()
    }

}