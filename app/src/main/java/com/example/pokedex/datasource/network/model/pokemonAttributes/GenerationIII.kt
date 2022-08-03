package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationIII(
    @Embedded
    val emerald: Emerald,
    @Embedded
    val fireredLeafgreen: EditionGenIII,
    @Embedded
    val rubySapphire: EditionGenIII
)