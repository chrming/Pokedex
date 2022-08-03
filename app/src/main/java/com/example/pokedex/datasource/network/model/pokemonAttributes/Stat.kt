package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class Stat(
    val base_stat: Int,
    val effort: Int,
    @Embedded
    val stat: Attribute
)