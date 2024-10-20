package dev.rulsoft.oprbattles.data.model

data class Shop(
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
