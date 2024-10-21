package dev.rulsoft.oprbattles.shop.presentation.models

import dev.rulsoft.oprbattles.shop.domain.Shop

data class ShopUi(
    val uid: String,
    val displayName: String,
    val email: String,
    val photoUrl: String,
    val phone: String,
    val address: String,
    val openingHour: String,
    val manager: String,
    val hasEventSpace: Boolean
)

fun Shop.toShopUi(): ShopUi {
    return ShopUi(
        uid = uid,
        displayName = displayName,
        email = email,
        photoUrl = photoUrl,
        phone = phone,
        address = address,
        openingHour = openingHour,
        manager = manager,
        hasEventSpace = hasEventSpace
    )
}
