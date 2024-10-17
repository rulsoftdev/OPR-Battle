package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClubDetailViewModel(private val uid: String) : ViewModel() {

    private var repository =  ClubRepository()

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(loading = false, club = repository.fetchClubById(uid))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val club: Club? = null
    )
}