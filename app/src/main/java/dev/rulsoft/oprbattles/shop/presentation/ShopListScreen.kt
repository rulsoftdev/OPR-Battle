package dev.rulsoft.oprbattles.shop.presentation

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.shop.presentation.models.ShopUi
import dev.rulsoft.oprbattles.ui.composable.ShopList

@Composable
fun ShopListScreen(onShopClick: (ShopUi) -> Unit) {
    ShopList(
        onShopClick = onShopClick
    )
}

