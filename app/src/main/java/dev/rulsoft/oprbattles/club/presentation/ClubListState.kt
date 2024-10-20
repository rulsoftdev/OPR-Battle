package dev.rulsoft.oprbattles.club.presentation

import androidx.compose.runtime.Immutable
import dev.rulsoft.oprbattles.club.presentation.models.ClubUi

@Immutable
data class ClubListState (
    val loading: Boolean = false,
    val clubs: List<ClubUi> = emptyList()
)