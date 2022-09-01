package com.example.pokedex.datasource.local.db.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.PokemonUiItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon WHERE (id OR name) = :idOrName")
    suspend fun getPokemon(idOrName: String): Pokemon

    @Query("DELETE FROM POKEMON")
    suspend fun deleteAllPokemon()

    @Query("SELECT * FROM pokemon")
    fun getAllPokemons(): PagingSource<Int, Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemons(pokemons: List<Pokemon>)
}