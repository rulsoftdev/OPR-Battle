package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.ui.composable.ClubList

@Composable
fun ClubListScreen(onClubClick: (Club) -> Unit) {
    ClubList(
        onClubClick = onClubClick
    )
}

