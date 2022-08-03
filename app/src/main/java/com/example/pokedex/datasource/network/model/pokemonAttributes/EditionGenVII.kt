package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class EditionGenVII(
    val front_default: String,
    @Embedded
    val front_female: Any,
    val front_shiny: String,
    @Embedded
    val front_shiny_female: Any
)