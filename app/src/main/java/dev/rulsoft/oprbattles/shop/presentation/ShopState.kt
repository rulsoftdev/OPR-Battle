package dev.rulsoft.oprbattles.shop.presentation

import dev.rulsoft.oprbattles.shop.presentation.models.ShopUi

data class ShopState(
    val loading: Boolean = false,
    val shop: ShopUi? = null,
    val message: String? = null
)
