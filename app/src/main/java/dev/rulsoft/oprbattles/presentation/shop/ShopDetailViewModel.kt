package dev.rulsoft.oprbattles.presentation.shop

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.core.navigation.ShopNav
import dev.rulsoft.oprbattles.data.shop.networking.ShopDataSource
import dev.rulsoft.oprbattles.presentation.shop.models.toShopUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopDetailViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var repository =  ShopDataSource()

    private val uid = savedStateHandle.toRoute<ShopNav>().uid

    private val _state = MutableStateFlow(ShopState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ShopState(loading = true)
            val shop = repository.fetchShopById(uid)
            if (shop != null) {
                _state.value = ShopState(loading = false, shop = shop.toShopUi())
            } else {
                _state.value = ShopState(loading = false)
            }

        }
    }

    fun onFavoriteClick() {
        _state.update { it.copy(message = "Favorite Clicked") }
        Log.d("ShopDetailViewModel", _state.value.toString())
    }

    fun onMessageShown() {
        _state.update { it.copy(message = null) }
    }

}