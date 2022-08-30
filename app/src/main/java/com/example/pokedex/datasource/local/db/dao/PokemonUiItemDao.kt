package com.example.pokedex.datasource.local.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.datasource.model.PokemonUiItem

@Dao
interface PokemonUiItemDao {

    @Query("SELECT * FROM pokemon_ui_item_table")
    fun getAllPokemonUiItems(): PagingSource<Int, PokemonUiItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemonUiItems(pokemonsUiItems: List<PokemonUiItem>)

    @Query("DELETE FROM pokemon_ui_item_table")
    fun deleteAllPokemonsUiItems()
}
