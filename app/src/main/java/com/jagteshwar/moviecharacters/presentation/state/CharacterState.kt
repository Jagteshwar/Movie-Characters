package com.jagteshwar.moviecharacters.presentation.state

import com.jagteshwar.moviecharacters.domain.model.Character

data class CharacterState(
    val characterList: List<Character>? = emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)
