package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationIV(
    @Embedded(prefix = "diamond_pearl_")
    val diamondPearl: EditionGenIV,
    @Embedded(prefix = "heartgold_soulsilver_")
    val heartgoldSoulsilver: EditionGenIV,
    @Embedded(prefix = "platinum_")
    val platinum: EditionGenIV
)