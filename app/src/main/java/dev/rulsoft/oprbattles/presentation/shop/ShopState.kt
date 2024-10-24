package dev.rulsoft.oprbattles.presentation.shop

import dev.rulsoft.oprbattles.presentation.shop.models.ShopUi

data class ShopState(
    val loading: Boolean = false,
    val shop: ShopUi? = null,
    val message: String? = null
)
