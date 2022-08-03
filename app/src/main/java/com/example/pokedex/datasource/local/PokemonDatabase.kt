package com.example.pokedex.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse

@Database(entities = [PokemonForUi::class, PokemonListResponse::class, Pokemon::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        const val DATABASE_NAME = "pokemon_db"
    }
}