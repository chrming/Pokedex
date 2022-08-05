package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationII(
    @Embedded(prefix = "crystal_")
    val crystal: EditionGenII,
    @Embedded(prefix = "gold_")
    val gold: EditionGenII,
    @Embedded(prefix = "silver_")
    val silver: EditionGenII
)