package com.example.pokedex.di

import android.app.Application
import androidx.room.Room
import com.example.pokedex.datasource.local.PokemonDao
import com.example.pokedex.datasource.local.PokemonDatabase
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.local.repository.PokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.datasource.network.repository.ApiPokemonRepository
import com.example.pokedex.datasource.network.PokemonApi
import com.example.pokedex.pokemonList.domain.useCase.GetPokemonListItemUseCase
import com.example.pokedex.pokemonList.domain.useCase.GetPokemonListUseCase
import com.example.pokedex.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun provideApiPokemonRepository(api: PokemonApi): IApiPokemonRepository {
        return ApiPokemonRepository(api)
    }

    @Provides
    @Singleton
    fun providePokemonReposotory(dao: PokemonDao): IPokemonRepository {
        return PokemonRepository(dao)
    }

    @Provides
    @Singleton
    fun providePokemonListUseCaseWrapper(apiRepo: IApiPokemonRepository, localRepo: IPokemonRepository): PokemonListUseCaseWrapper {
        return PokemonListUseCaseWrapper(
            getPokemonList = GetPokemonListUseCase(apiRepo, localRepo),
            getPokemonListItem = GetPokemonListItemUseCase(apiRepo, localRepo)
        )
    }

    @Provides
    @Singleton
    fun providePokemonDatabase(app: Application): PokemonDatabase{
        return Room.databaseBuilder(
            app,
            PokemonDatabase::class.java,
            PokemonDatabase.DATABASE_NAME
        ).build()
    }
}