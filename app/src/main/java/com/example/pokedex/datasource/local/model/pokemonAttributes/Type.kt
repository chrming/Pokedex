package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Type(
    val slot: Int,
    @Embedded
    val type: Attribute
)