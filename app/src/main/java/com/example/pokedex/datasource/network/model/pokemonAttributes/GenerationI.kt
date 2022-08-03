package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationI(
    @Embedded
    val redBlue: EditionGenI,
    @Embedded
    val yellow: EditionGenI
)