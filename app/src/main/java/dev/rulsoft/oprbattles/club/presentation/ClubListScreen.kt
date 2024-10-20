package dev.rulsoft.oprbattles.club.presentation

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.club.presentation.models.ClubUi
import dev.rulsoft.oprbattles.ui.composable.ClubList

@Composable
fun ClubListScreen(onClubClick: (ClubUi) -> Unit) {
    ClubList(
        onClubClick = onClubClick
    )
}

