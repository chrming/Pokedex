package com.example.pokedex.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.const.Constants.POKEMON_REMOTE_KEYS_TABLE

@Entity(tableName = POKEMON_REMOTE_KEYS_TABLE)
data class PokemonRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
