package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVIII(
    @Embedded
    val icons: Icons
)