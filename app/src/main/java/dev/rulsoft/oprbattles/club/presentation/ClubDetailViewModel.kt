package dev.rulsoft.oprbattles.club.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.club.data.networking.ClubDataSource
import dev.rulsoft.oprbattles.club.presentation.models.toClubUi
import dev.rulsoft.oprbattles.core.navigation.ClubNav
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubDetailViewModel
@Inject
constructor(
    private val repository: ClubDataSource,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val uid = savedStateHandle.toRoute<ClubNav>().uid

    private val _state = MutableStateFlow(ClubState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ClubState(loading = true)
            val club = repository.fetchClubById(uid)
            if (club != null) {
                _state.value = ClubState(loading = false, club = club.toClubUi())
            } else {
                _state.value = ClubState(loading = false)
            }
        }
    }

}