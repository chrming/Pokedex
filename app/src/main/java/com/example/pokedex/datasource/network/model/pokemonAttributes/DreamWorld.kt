package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class DreamWorld(
   @ColumnInfo(name = "dream_world_frond_default")
    val front_default: String,
    @Embedded
    val front_female: Any
)