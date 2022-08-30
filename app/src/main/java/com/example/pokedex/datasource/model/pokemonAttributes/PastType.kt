package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class PastType(
    @Embedded
    val generation: Attribute,
    val types: List<Type>
)