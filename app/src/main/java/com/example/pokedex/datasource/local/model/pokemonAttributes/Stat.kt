package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Stat(
    val base_stat: Int,
    val effort: Int,
    @Embedded
    val stat: Attribute
)