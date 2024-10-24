package dev.rulsoft.oprbattles.presentation.shop

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.presentation.shop.models.ShopUi
import dev.rulsoft.oprbattles.ui.composable.ShopList

@Composable
fun ShopListScreen(onShopClick: (ShopUi) -> Unit) {
    ShopList(
        onShopClick = onShopClick
    )
}

