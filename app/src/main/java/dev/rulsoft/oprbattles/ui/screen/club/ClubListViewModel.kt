package dev.rulsoft.oprbattles.ui.screen.club

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.launch

private const val TAG = "ClubListViewModel"

class ClubListViewModel: ViewModel() {

    private val repository = ClubRepository()

    var state by mutableStateOf(UiState())
        private set

    fun onUiReady() {
        viewModelScope.launch {
            state = UiState(loading = true)
            val clubs = repository.fetchClubs()
            Log.d(TAG, "$clubs")
            state = UiState(loading = false, clubs = clubs)
        }

    }

    data class UiState(
        val loading: Boolean = false,
        val clubs: List<Club> = emptyList()
    )

}