package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class Icons(
    val front_default: String,
    @Embedded
    val front_female: Any
)