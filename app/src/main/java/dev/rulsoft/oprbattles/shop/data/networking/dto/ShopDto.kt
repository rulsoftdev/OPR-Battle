package dev.rulsoft.oprbattles.shop.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ShopDto(
    val uid: String = "",
    val displayName: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val phone: String = "",
    val address: String = "",
    val openingHour: String = "",
    val manager: String = "",
    val hasEventSpace: Boolean = false
)
