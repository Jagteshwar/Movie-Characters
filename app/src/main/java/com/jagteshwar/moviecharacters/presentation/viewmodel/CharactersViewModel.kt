package com.jagteshwar.moviecharacters.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagteshwar.moviecharacters.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val getCharacters: GetCharactersUseCase
): ViewModel() {

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        getCharacters().onEach {
            it.data?.map {

            }
        }.launchIn(viewModelScope)
    }
}