package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVI(
    @Embedded
    val omegarubyAlphasapphire: EditionGenVI,
    @Embedded
    val xy: EditionGenVI
)