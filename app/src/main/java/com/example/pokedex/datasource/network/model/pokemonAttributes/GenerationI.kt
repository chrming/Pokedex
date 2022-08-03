package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationI(
    @Embedded(prefix = "red_blue_")
    val redBlue: EditionGenI,
    @Embedded(prefix = "yellow_")
    val yellow: EditionGenI
)