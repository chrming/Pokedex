package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationII(
    @Embedded
    val crystal: EditionGenII,
    @Embedded
    val gold: EditionGenII,
    @Embedded
    val silver: EditionGenII
)