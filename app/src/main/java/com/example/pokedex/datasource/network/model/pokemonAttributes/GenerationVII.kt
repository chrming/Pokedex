package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVII(
    @Embedded(prefix = "genvii_icons_")
    val icons: Icons,
    @Embedded(prefix = "ulstrasun_ultramoon_")
    val ultraSunUltraMoon: EditionGenVII
)