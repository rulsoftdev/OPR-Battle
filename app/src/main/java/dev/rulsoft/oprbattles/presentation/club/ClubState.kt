package dev.rulsoft.oprbattles.presentation.club

import dev.rulsoft.oprbattles.presentation.club.models.ClubUi

data class ClubState(
    val loading: Boolean = false,
    val club: ClubUi? = null
)

