package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationIII(
    @Embedded(prefix = "emerald_")
    val emerald: Emerald,
    @Embedded(prefix = "firered_leafgreen_")
    val fireredLeafgreen: EditionGenIII,
    @Embedded(prefix = "ruby_sapphire_")
    val rubySapphire: EditionGenIII
)