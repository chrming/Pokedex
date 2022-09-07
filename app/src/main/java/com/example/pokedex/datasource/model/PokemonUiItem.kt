package com.example.pokedex.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokedex.const.Constants.BASE_URL
import com.example.pokedex.const.Constants.POKEMON_UI_ITEM_TABLE
import com.example.pokedex.datasource.model.pokemonAttributes.Type


@Entity(tableName = POKEMON_UI_ITEM_TABLE)
@TypeConverters
data class PokemonUiItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val officialArtwork: String,
    val types: List<Type>,
    val url: String = BASE_URL + "$id"
)
