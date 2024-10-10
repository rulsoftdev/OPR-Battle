package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import dev.rulsoft.oprbattles.ui.composable.common.topBars.DetailAppBar

@Composable
fun ClubDetailScreen(
    viewModel: ClubDetailViewModel,
    onBack: () -> Unit
){
    val state = viewModel.state
    if (state.loading) {
        CircularProgressIndicator()
    }
    state.club?.let { club ->
        Column(
            modifier = Modifier
                .padding(16.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AsyncImage(
                    model = club.photoURL,
                    contentDescription = "Imagen del club"
                )
                Text(
                    text = club.displayName,
                    style = MaterialTheme.typography.displaySmall
                )
            }
            Column (
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = "Email: ${club.email}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Teléfono: ${club.phone}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Dirección: ${club.address}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

}

