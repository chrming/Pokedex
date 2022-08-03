package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class Type(
    val slot: Int,
    @Embedded
    val type: Attribute
)