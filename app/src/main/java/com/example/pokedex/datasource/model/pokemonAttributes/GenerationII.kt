package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationII(
    @Embedded(prefix = "crystal_")
    val crystal: Crystal?,
    @Embedded(prefix = "gold_")
    val gold: EditionGenII?,
    @Embedded(prefix = "silver_")
    val silver: EditionGenII?
) {
    constructor() : this(Crystal(), EditionGenII(), EditionGenII())
}