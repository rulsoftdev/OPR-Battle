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
import dev.rulsoft.oprbattles.shop.presentation.ShopListViewModel
import dev.rulsoft.oprbattles.shop.presentation.models.ShopUi

@Composable
fun ShopList(
    modifier: Modifier = Modifier,
    shopListViewModel: ShopListViewModel = viewModel(),
    onShopClick: (ShopUi) -> Unit
) {
    val state by shopListViewModel.state.collectAsState()

    LaunchedEffect(key1= Unit) { // Llama a onUiReady() una sola vez
        shopListViewModel.onUiReady()
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
        items(state.shops) { shop ->
            ShopItem(
                shop = shop,
                onClick = { onShopClick(shop) },
                modifier = Modifier
            )
        }
    }
}