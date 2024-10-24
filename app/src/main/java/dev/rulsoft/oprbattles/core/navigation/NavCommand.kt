package dev.rulsoft.oprbattles.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import dev.rulsoft.oprbattles.R
import kotlinx.serialization.Serializable

@Serializable
data object ClubsNav
@Serializable
data class ClubNav(val uid: String)
@Serializable
data object ShopsNav
@Serializable
data class ShopNav(val uid: String)

data class NavCommand<T: Any>(
    val route: T,
    @StringRes val title: Int
)

enum class NavItem(
    val navCommand: NavCommand<Any>,
    val icon: ImageVector? = null
) {
    CLUBS(NavCommand(ClubsNav, R.string.title_clubs), Icons.Default.Home),
    CLUB(NavCommand(ClubNav(""), R.string.title_club_detail)),
    SHOPS(NavCommand(ShopsNav, R.string.title_shops), Icons.Default.ShoppingCart),
    SHOP(NavCommand(ShopNav(""), R.string.title_shop_detail))
}