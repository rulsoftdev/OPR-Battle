package dev.rulsoft.oprbattles.club.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ClubDto(
    val uid: String = "",
    val displayName: String = "",
    val descripcion: String = "",
    val email: String = "",
    val backdrop: String = "",
    val photoURL: String = "",
    val phone: String = "",
    val address: String = "",
    val members: List<String> = emptyList()
)