package dev.rulsoft.oprbattles.data.club.mappers

import dev.rulsoft.oprbattles.data.club.networking.dto.ClubDto
import dev.rulsoft.oprbattles.domain.club.Club

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