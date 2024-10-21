package dev.rulsoft.oprbattles.ui

import android.util.Log
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.rulsoft.oprbattles.R
import dev.rulsoft.oprbattles.core.navigation.ClubNav
import dev.rulsoft.oprbattles.core.navigation.ClubsNav
import dev.rulsoft.oprbattles.core.navigation.NavItem
import dev.rulsoft.oprbattles.core.navigation.ShopNav
import dev.rulsoft.oprbattles.core.navigation.ShopsNav
import dev.rulsoft.oprbattles.core.navigation.navigatePoppingUpToStartDestination
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
        val BOTTOM_NAV_OPTIONS: List<NavItem> = listOf(NavItem.CLUBS, NavItem.SHOPS)
        val BOTTOM_DESTINATIONS = listOf(ClubsNav, ShopsNav)
        val UP_DESTINATIONS = listOf(ClubNav(""), ShopNav(""))
    }

    val getBottomOptions: List<NavItem>
        @Composable get() = BOTTOM_NAV_OPTIONS

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val showUpNavigation: Boolean
        @Composable get() {
            return UP_DESTINATIONS.any { destination ->
                currentDestination?.hierarchy?.any {
                    it.hasRoute(destination::class)
                } == true
            }
        }

    val showBottomNavigation: Boolean
        @Composable get() {
            return BOTTOM_DESTINATIONS.any { destination ->
                currentDestination?.hierarchy?.any {
                    it.hasRoute(destination::class)
                } == true
            }
        }

    fun onBackClick() {
        navController.popBackStack()
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand)
    }

    @Composable
    fun getTitleScreen(): Int {
        val navItem = NavItem.entries.find { destination ->
            currentDestination?.hierarchy?.any {
                val route = destination.navCommand.route
                Log.d(TAG, "destination: ${route::class}")
                it.hasRoute(route::class)
            } == true
        }
        return navItem?.navCommand?.title ?: R.string.sin_title
    }
}

