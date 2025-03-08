package com.jagteshwar.moviecharacters.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagteshwar.moviecharacters.core.common.Resource
import com.jagteshwar.moviecharacters.domain.usecases.GetCharactersUseCase
import com.jagteshwar.moviecharacters.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacters: GetCharactersUseCase
): ViewModel() {

    private val _characterState = MutableStateFlow(CharacterState())
    val characterState: StateFlow<CharacterState>
        get() = _characterState


    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        getCharacters().onEach {
            when(it){
                is Resource.Error -> {
                    _characterState.value = CharacterState().copy(
                        errorMsg = it.msg
                    )
                }
                is Resource.Loading -> {
                    _characterState.value = CharacterState().copy(isLoading = true)
                }
                is Resource.Success -> _characterState.value = CharacterState().copy(characterList = it.data)
            }
        }.launchIn(viewModelScope)
    }
}