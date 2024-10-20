package dev.rulsoft.oprbattles.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.rulsoft.oprbattles.R

enum class NavItem(
    val navCommand: NavCommand,
    val icon: ImageVector,
    @StringRes val title: Int,
    @StringRes val title_detail: Int
){
    CLUBS(NavCommand.ContentType(Feature.CLUBS), Icons.Default.Home, R.string.title_clubs, R.string.title_club_detail),
    SHOP(NavCommand.ContentType(Feature.SHOPS), Icons.Default.ShoppingCart, R.string.title_shops, R.string.title_shop_detail)
}

sealed class NavCommand(
    internal val feature: Feature,
    internal val subRoute: String = "home",
    private val navArgs: List<NavArg> = emptyList()
){
    class ContentType(feature: Feature) : NavCommand(feature)

    class ContentTypeDetail(feature: Feature) : NavCommand(
        feature, "detail",
        listOf(NavArg.UId))
    {
        fun createRoute(itemId: String) = "${feature.route}/$subRoute/$itemId"
    }


    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route, subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg (val key: String, val navType: NavType<*>){
    UId("uid", NavType.StringType),
}