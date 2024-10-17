package dev.rulsoft.oprbattles.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.ui.screen.club.ClubListViewModel

@Composable
fun ClubList(
    modifier: Modifier = Modifier,
    clubListViewModel: ClubListViewModel = viewModel(),
    onClubClick: (Club) -> Unit
) {
    val state by clubListViewModel.state.collectAsState()

    LaunchedEffect(key1= Unit) { // Llama a onUiReady() una sola vez
        clubListViewModel.onUiReady()
    }

    if(state.loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
    LazyColumn(modifier = modifier) {
        items(state.clubs) { club ->
            ClubCard(
                club = club,
                onClick = { onClubClick(club) },
                modifier = Modifier
            )
        }
    }
}