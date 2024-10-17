package dev.rulsoft.oprbattles.ui.screen.shop

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.data.Shop
import dev.rulsoft.oprbattles.ui.composable.ShopList

@Composable
fun ShopListScreen(onShopClick: (Shop) -> Unit) {
    ShopList(
        onShopClick = onShopClick
    )
}

