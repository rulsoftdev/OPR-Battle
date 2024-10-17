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
import dev.rulsoft.oprbattles.navigations.Feature
import dev.rulsoft.oprbattles.navigations.NavCommand
import dev.rulsoft.oprbattles.navigations.NavItem
import dev.rulsoft.oprbattles.navigations.navigatePoppingUpToStartDestination
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

    companion object {
        val BOTTOM_NAV_OPTIONS = listOf(NavItem.CLUBS, NavItem.SHOP)
    }

    val title_screen : Int  //TODO: Ocasional hay que pensar como gestionar los titulos de las bars en funcion de currentRoute
        @Composable get() = when(currentRoute) {
            NavCommand.ContentType(Feature.CLUBS).route -> NavItem.CLUBS.title
            NavCommand.ContentTypeDetail(Feature.CLUBS).route -> NavItem.CLUBS.title_detail
            NavCommand.ContentType(Feature.SHOPS).route -> NavItem.SHOP.title
            NavCommand.ContentTypeDetail(Feature.SHOPS).route -> NavItem.SHOP.title_detail
            else -> R.string.app_title
        }

    val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    val showUpNavigation: Boolean
        @Composable get() = currentRoute !in NavItem.entries.map { it.navCommand.route }

    val showBottomNavigation: Boolean
        @Composable get() = BOTTOM_NAV_OPTIONS.any { currentRoute.contains("${it.navCommand.feature.route}/home") }

    fun onBackClick() {
        navController.popBackStack()
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }
}