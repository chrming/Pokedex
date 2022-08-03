package com.example.pokedex.datasource.local.db

import androidx.room.*
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi

@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemon WHERE (id OR name) = :idOrName")
    suspend fun getPokemon(idOrName: String): Pokemon

    @Query("SELECT * FROM Pokemon")
    suspend fun getPokemonList(): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)
}