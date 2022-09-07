package com.example.pokedex.di

import com.example.pokedex.datasource.local.db.PokemonDatabase
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.local.repository.PokemonRepository
import com.example.pokedex.datasource.network.api.IPokemonApi
import com.example.pokedex.datasource.network.repository.IPokemonApiRepository
import com.example.pokedex.datasource.network.repository.PokemonApiRepository
import com.example.pokedex.datasource.paging.repository.PokemonPagingRepository
import com.example.pokedex.screens.pokemonDetail.domain.useCase.PokemonDetailUseCaseWrapper
import com.example.pokedex.screens.pokemonList.domain.useCase.GetPokemonListUseCase
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {



    @Provides
    @Singleton
    fun provideApiPokemonRepository(api: IPokemonApi): IPokemonApiRepository {
        return PokemonApiRepository(api)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(db: PokemonDatabase): IPokemonRepository {
        return PokemonRepository(db.pokemonDao())
    }


    @Provides
    @Singleton
    fun providePokemonPagingRepository(
        api: IPokemonApiRepository,
        db: PokemonDatabase
    ): PokemonPagingRepository {
        return PokemonPagingRepository(api, db)
    }

    @Provides
    @Singleton
    fun providePokemonListUseCaseWrapper(
        repository: PokemonPagingRepository
    ): PokemonListUseCaseWrapper {
        return PokemonListUseCaseWrapper(
            getPokemonList = GetPokemonListUseCase(repository),
        )
    }

    @Provides
    @Singleton
    fun provideHomeUseCaseWrapper(
        apiRepo: IPokemonApiRepository,
        localRepo: IPokemonRepository
    ): PokemonDetailUseCaseWrapper {
        return PokemonDetailUseCaseWrapper(
            getPokemonByName = com.example.pokedex.screens.pokemonDetail.domain.useCase.GetPokemonByNameUseCase(
                apiRepo,
                localRepo
            ),
        )
    }
}