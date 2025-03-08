package com.jagteshwar.moviecharacters.di

import com.jagteshwar.moviecharacters.core.utils.Constants
import com.jagteshwar.moviecharacters.data.remote.CharacterApi
import com.jagteshwar.moviecharacters.data.repository.CharacterRepositoryImpl
import com.jagteshwar.moviecharacters.domain.repository.CharacterRepository
import com.jagteshwar.moviecharacters.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesCharactersApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun providesCharacterRepository(api: CharacterApi): CharacterRepository = CharacterRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesGetCharactersUseCases(repository: CharacterRepository): GetCharactersUseCase = GetCharactersUseCase(repository)
}