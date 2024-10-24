package dev.rulsoft.oprbattles.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.rulsoft.oprbattles.presentation.club.models.ClubUi
import dev.rulsoft.oprbattles.core.presentation.util.Property

@Composable
fun ClubDetail(club: ClubUi) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = club.backdrop,
                    contentDescription = "Imagen del club"
                )
            }
            Column (
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = club.displayName,
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = club.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = buildAnnotatedString {
                            Property("Email", club.email)
                            Property("Teléfono", club.phone)
                            Property("Dirección", club.address)
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.secondaryContainer)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
