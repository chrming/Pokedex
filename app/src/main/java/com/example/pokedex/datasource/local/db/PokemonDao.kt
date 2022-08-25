package com.example.pokedex.datasource.local.db

import androidx.room.*
import com.example.pokedex.datasource.local.model.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon WHERE (id OR name) = :idOrName")
    suspend fun getPokemon(idOrName: String): Pokemon

    @Query("SELECT * FROM pokemon")
    fun getPokemonList(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id BETWEEN (:pageNumber) * :pageSize AND :pageNumber  * :pageSize - 1")
    fun getPokemonListPage(pageNumber: Int, pageSize: Int): List<Pokemon>

    @Query("SELECT * FROM pokemon")
    fun isDatabaseEmpty(): List<Pokemon>

    @Insert(entity = Pokemon::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)
}