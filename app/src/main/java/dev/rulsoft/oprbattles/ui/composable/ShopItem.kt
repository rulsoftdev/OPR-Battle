package dev.rulsoft.oprbattles.ui.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.rulsoft.oprbattles.R
import dev.rulsoft.oprbattles.shop.presentation.models.ShopUi

@Composable
fun ShopItem(
    shop: ShopUi,
    onClick: (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClick(shop)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = shop.photoUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Foto del club",
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.size_image_list))
                        .padding(end = dimensionResource(id = R.dimen.padding_medium))
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = shop.displayName,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = shop.email, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(MaterialTheme.colorScheme.inverseSurface)
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.End
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clickable {
                        // Abre la ubicación en Google Maps (reemplaza con la dirección real)
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("tel:${shop.phone}")
                        )
                        context.startActivity(intent)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Outlined.Phone, // Reemplaza con tu icono de mapa
                        contentDescription = "LLamar a",
                        tint = MaterialTheme.colorScheme.inverseOnSurface
                    )
                    Text(
                        text = shop.phone,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clickable {
                        // Abre la ubicación en Google Maps (reemplaza con la dirección real)
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=${shop.address}")
                        )
                        context.startActivity(intent)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Outlined.LocationOn, // Reemplaza con tu icono de mapa
                        contentDescription = "Ver en mapa",
                        tint = MaterialTheme.colorScheme.inverseOnSurface
                    )
                    Text(
                        text = "Dirección",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                }
            }
        }
    }
}