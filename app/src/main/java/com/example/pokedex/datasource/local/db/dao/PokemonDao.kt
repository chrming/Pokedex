package com.example.pokedex.datasource.local.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.datasource.model.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon WHERE name =:name")
    suspend fun getPokemon(name: String): Pokemon

    @Query("DELETE FROM POKEMON")
    suspend fun deleteAllPokemon()

    @Query("SELECT * FROM pokemon")
    fun getAllPokemons(): PagingSource<Int, Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemons(pokemons: List<Pokemon>)
}