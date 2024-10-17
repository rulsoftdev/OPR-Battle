package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ClubDetailScreen(
    viewModel: ClubDetailViewModel,
    onBack: () -> Unit
){
    val state by viewModel.state.collectAsState()
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

