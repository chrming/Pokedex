package com.example.pokedex.di

import android.app.Application
import androidx.room.Room
import com.example.pokedex.datasource.local.db.PokemonDatabase
import com.example.pokedex.datasource.local.model.AttributesTypeConverter
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.local.repository.PokemonRepository
import com.example.pokedex.datasource.network.PokemonApi
import com.example.pokedex.datasource.network.repository.ApiPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.pokemonList.domain.useCase.*
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
            .baseUrl("https://pokeapi.co/api/v2/")
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
    fun providePokemonRepository(db: PokemonDatabase): IPokemonRepository {
        return PokemonRepository(db.pokemonDao())
    }

    @Provides
    @Singleton
    fun providePokemonListUseCaseWrapper(
        apiRepo: IApiPokemonRepository,
        localRepo: IPokemonRepository
    ): PokemonListUseCaseWrapper {
        return PokemonListUseCaseWrapper(
            getPokemonList = GetPokemonListUseCase(apiRepo, localRepo),
            getPokemon = GetPokemonUseCase(apiRepo, localRepo),
            insertPokemon = InsertPokemonUseCase(localRepo),
            deletePokemonUseCase = DeletePokemonUseCase(localRepo)
        )
    }

    @Provides
    @Singleton
    fun providePokemonDatabase(app: Application): PokemonDatabase {
        return Room.databaseBuilder(
            app,
            PokemonDatabase::class.java,
            PokemonDatabase.DATABASE_NAME
        ).addTypeConverter(AttributesTypeConverter())
            .build()
    }
}