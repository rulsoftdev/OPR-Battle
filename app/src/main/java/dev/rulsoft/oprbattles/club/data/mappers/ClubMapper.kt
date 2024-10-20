package dev.rulsoft.oprbattles.club.data.mappers

import dev.rulsoft.oprbattles.club.data.networking.dto.ClubDto
import dev.rulsoft.oprbattles.club.domain.Club

fun ClubDto.toClub(): Club {
    return Club(
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