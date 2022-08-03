package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationIV(
    @Embedded
    val diamondPearl: EditionGenIV,
    @Embedded
    val heartgoldSoulsilver: EditionGenIV,
    @Embedded
    val platinum: EditionGenIV
)