package dev.rulsoft.oprbattles.ui.screen.club

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "ClubListViewModel"

class ClubListViewModel: ViewModel() {

    private val repository = ClubRepository()

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            val clubs = repository.fetchClubs()
            _state.value = UiState(loading = false, clubs = clubs)
        }

    }

    data class UiState(
        val loading: Boolean = false,
        val clubs: List<Club> = emptyList()
    )

}