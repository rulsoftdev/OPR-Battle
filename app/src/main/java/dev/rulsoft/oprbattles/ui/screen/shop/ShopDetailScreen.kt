package dev.rulsoft.oprbattles.ui.screen.shop

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dev.rulsoft.oprbattles.ui.composable.ClubDetail
import dev.rulsoft.oprbattles.ui.composable.common.topBars.ShopDetail

@Composable
fun ShopDetailScreen(
    viewModel: ShopDetailViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    if (state.loading) {
        CircularProgressIndicator()
    }
    if (state.shop != null) {
        ShopDetail(shop = state.shop!!)
    }
}


