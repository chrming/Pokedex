package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationV(
    @Embedded(prefix = "balckwhite_")
    val blackWhite: BlackWhite
)