package com.jagteshwar.moviecharacters.data.repository

import com.jagteshwar.moviecharacters.core.common.Resource
import com.jagteshwar.moviecharacters.data.dto.CharacterDto
import com.jagteshwar.moviecharacters.data.mapper.toCharacter
import com.jagteshwar.moviecharacters.data.remote.CharacterApi
import com.jagteshwar.moviecharacters.domain.model.Character
import com.jagteshwar.moviecharacters.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi
): CharacterRepository {
    override fun getAllCharacter(): Flow<Resource<List<Character>>> {
        return flow {
            emit(Resource.Loading())
            val result = api.getAllCharacters().map { it.toCharacter() }
            emit(Resource.Success(result))
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }
}