package com.example.pokedex.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonForUi WHERE id = :id")
    fun getPokemon(id: Int): PokemonForUi

    @Query("SELECT * FROM PokemonListResponse")
    fun getPokemonList(): PokemonListResponse

    @Query("SELECT * FROM Pokemon WHERE url = :url")
    suspend fun getPokemonListItem(url: String): Pokemon

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonForUi(pokemon: PokemonForUi)
}