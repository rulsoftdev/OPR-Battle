package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.launch

class ClubDetailViewModel(private val uid: String) : ViewModel() {

    private var repository =  ClubRepository()

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(loading = false, club = repository.fetchClubById(uid))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val club: Club? = null
    )
}