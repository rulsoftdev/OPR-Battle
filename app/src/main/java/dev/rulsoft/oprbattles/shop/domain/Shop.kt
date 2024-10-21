package dev.rulsoft.oprbattles.shop.domain

data class Shop(
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
