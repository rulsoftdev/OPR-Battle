package dev.rulsoft.oprbattles.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.rulsoft.oprbattles.core.navigation.ShopNav
import dev.rulsoft.oprbattles.core.navigation.ShopsNav
import dev.rulsoft.oprbattles.shop.presentation.ShopDetailScreen
import dev.rulsoft.oprbattles.shop.presentation.ShopListScreen
import kotlinx.serialization.Serializable

@Serializable
object ShopGraph

fun NavGraphBuilder.shopGraph(navController: NavHostController){
    navigation<ShopGraph>(startDestination = ShopsNav){
        composable<ShopsNav> {
            ShopListScreen(
                onShopClick = { shop ->
                    navController.navigate(ShopNav(shop.uid))
                }
            )
        }
        composable<ShopNav> {
            ShopDetailScreen()
        }
    }
}