package dev.rulsoft.oprbattles.shop.data.mappers

import dev.rulsoft.oprbattles.shop.data.networking.dto.ShopDto
import dev.rulsoft.oprbattles.shop.domain.Shop

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