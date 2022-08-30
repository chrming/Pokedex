package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class Type(
    val slot: Int,
    @Embedded
    val type: Attribute
)