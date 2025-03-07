package com.jagteshwar.moviecharacters.domain.repository

import com.jagteshwar.moviecharacters.core.common.Resource
import com.jagteshwar.moviecharacters.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacter(): Flow<Resource<List<Character>>>
}