package dev.rulsoft.oprbattles.shop.presentation

import dev.rulsoft.oprbattles.shop.presentation.models.ShopUi

data class ShopListState (
    val loading: Boolean = false,
    val shops: List<ShopUi> = emptyList()
)