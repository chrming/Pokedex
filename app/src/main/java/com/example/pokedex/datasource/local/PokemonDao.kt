package com.example.pokedex.datasource.local

import androidx.room.*
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonForUi WHERE id = :id")
    suspend fun getPokemon(id: Int): PokemonForUi

    @Query("SELECT * FROM PokemonListResponse")
    suspend fun getPokemonList(): PokemonListResponse

    @Query("SELECT * FROM Pokemon WHERE (id OR name) = :idOrName")
    suspend fun getPokemonListItem(idOrName: String): Pokemon

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon): Unit

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon):Unit
}