package dev.rulsoft.oprbattles.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.rulsoft.oprbattles.club.presentation.ClubDetailScreen
import dev.rulsoft.oprbattles.club.presentation.ClubListScreen
import dev.rulsoft.oprbattles.ui.screen.shop.ShopDetailScreen
import dev.rulsoft.oprbattles.ui.screen.shop.ShopListScreen

private const val TAG = "Navigation"

@Composable
fun Navigation(navController: NavHostController, snackbarHostState: SnackbarHostState) {

    NavHost(
        navController = navController,
        startDestination = Feature.CLUBS.route
    ){
        clubsNav(navController)
        shopNav(navController)
    }
}

private fun NavGraphBuilder.clubsNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.CLUBS).route,
        route = Feature.CLUBS.route
    ){
        composable(NavCommand.ContentType(Feature.CLUBS)){
            ClubListScreen(
                onClubClick = { club ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.CLUBS).createRoute(club.uid)
                    )
                }
            )
        }
        composable(NavCommand.ContentTypeDetail(Feature.CLUBS)) {
            ClubDetailScreen()
        }
    }
}

private fun NavGraphBuilder.shopNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.SHOPS).route,
        route = Feature.SHOPS.route
    ){
        composable(NavCommand.ContentType(Feature.SHOPS)){
            ShopListScreen(
                onShopClick = { shop ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.SHOPS).createRoute(shop.uid)
                    )
                }
            )
        }
        composable(NavCommand.ContentTypeDetail(Feature.SHOPS)) {
            ShopDetailScreen()
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
){
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}