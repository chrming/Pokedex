package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class PastType(
    @Embedded
    val generation: Attribute,
    @Embedded
    val types: List<Type>
)