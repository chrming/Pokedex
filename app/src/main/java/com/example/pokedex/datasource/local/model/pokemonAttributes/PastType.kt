package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class PastType(
    @Embedded
    val generation: Attribute,
    val types: List<Type>
)