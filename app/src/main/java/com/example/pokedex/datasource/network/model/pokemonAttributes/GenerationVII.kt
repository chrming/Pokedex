package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVII(
    @Embedded
    val icons: Icons,
    @Embedded
    val ultraSunUltraMoon: GenerationVI
)