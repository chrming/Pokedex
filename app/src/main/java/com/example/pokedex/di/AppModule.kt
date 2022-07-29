package com.example.pokedex.di

import com.example.pokedex.datasource.IPokemonRepository
import com.example.pokedex.datasource.PokemonRepository
import com.example.pokedex.network.PokemonApi
import com.example.pokedex.pokemonList.useCase.GetPokemonListItemUseCase
import com.example.pokedex.pokemonList.useCase.GetPokemonListUseCase
import com.example.pokedex.pokemonList.useCase.PokemonListUseCaseWrapper
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/",)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonApi): IPokemonRepository {
        return PokemonRepository(api)
    }

    @Provides
    @Singleton
    fun providePokemonListUseCaseWrapper(repository: IPokemonRepository): PokemonListUseCaseWrapper {
        return PokemonListUseCaseWrapper(
            getPokemonList = GetPokemonListUseCase(repository),
            getPokemonListItem = GetPokemonListItemUseCase(repository)
        )
    }
}