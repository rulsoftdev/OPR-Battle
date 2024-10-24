package dev.rulsoft.oprbattles.data.shop.mappers

import dev.rulsoft.oprbattles.data.shop.networking.dto.ShopDto
import dev.rulsoft.oprbattles.domain.shop.Shop

fun ShopDto.toShop(): Shop {
    return Shop(
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