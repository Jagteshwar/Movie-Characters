package com.jagteshwar.moviecharacters.domain.usecases

import com.jagteshwar.moviecharacters.core.common.Resource
import com.jagteshwar.moviecharacters.domain.repository.CharacterRepository
import com.jagteshwar.moviecharacters.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

     operator fun invoke(): Flow<Resource<List<Character>>> {
        return repository.getAllCharacter()
    }
}