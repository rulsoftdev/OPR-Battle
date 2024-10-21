package dev.rulsoft.oprbattles.club.presentation

import dev.rulsoft.oprbattles.club.presentation.models.ClubUi

data class ClubState(
    val loading: Boolean = false,
    val club: ClubUi? = null
)
