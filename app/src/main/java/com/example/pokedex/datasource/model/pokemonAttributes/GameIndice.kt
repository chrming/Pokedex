package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class GameIndice(
    val game_index: Int,
    @Embedded
    val version: Attribute
)