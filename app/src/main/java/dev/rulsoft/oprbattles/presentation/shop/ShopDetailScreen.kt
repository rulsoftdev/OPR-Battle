package dev.rulsoft.oprbattles.presentation.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rulsoft.oprbattles.R
import dev.rulsoft.oprbattles.presentation.shop.holders.rememberShopDetailStateHolder
import dev.rulsoft.oprbattles.ui.composable.common.topBars.ShopDetail

@Composable
fun ShopDetailScreen(
    viewModel: ShopDetailViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val detailStateHolder = rememberShopDetailStateHolder()

    detailStateHolder.ShowMessageEffect(message = state.message){
        viewModel.onMessageShown()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(detailStateHolder.snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.onFavoriteClick() }) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = stringResource(id = R.string.fab_shop_favorite)
                )
            }
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
        ){
            if (state.loading) {
                CircularProgressIndicator()
            }
            if (state.shop != null) {
                ShopDetail(shop = state.shop!!)
            }
        }
    }

}


