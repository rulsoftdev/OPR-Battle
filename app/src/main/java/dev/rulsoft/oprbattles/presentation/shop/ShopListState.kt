package dev.rulsoft.oprbattles.presentation.shop

import dev.rulsoft.oprbattles.presentation.shop.models.ShopUi

data class ShopListState (
    val loading: Boolean = false,
    val shops: List<ShopUi> = emptyList()
)