package com.jagteshwar.moviecharacters.data.remote

import com.jagteshwar.moviecharacters.data.dto.CharacterDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterDto>
}