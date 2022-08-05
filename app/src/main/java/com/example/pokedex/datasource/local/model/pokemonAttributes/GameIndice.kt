package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class GameIndice(
    val game_index: Int,
    @Embedded
    val version: Attribute
)