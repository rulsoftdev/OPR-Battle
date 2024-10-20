package dev.rulsoft.oprbattles.club.presentation.models

import dev.rulsoft.oprbattles.club.domain.Club

data class ClubUi(
    val uid: String,
    val displayName: String,
    val descripcion: String,
    val email: String,
    val backdrop: String,
    val photoURL: String,
    val phone: String,
    val address: String,
    val members: List<String>
)

fun Club.toClubUi(): ClubUi {
    return ClubUi(
        uid = uid,
        displayName = displayName,
        descripcion = descripcion,
        email = email,
        backdrop = backdrop,
        photoURL = photoURL,
        phone = phone,
        address = address,
        members = members
    )
}