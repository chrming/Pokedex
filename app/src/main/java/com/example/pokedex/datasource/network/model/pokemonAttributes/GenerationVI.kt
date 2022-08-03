package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVI(
    @Embedded(prefix = "omegaruby_alphasapphire_")
    val omegarubyAlphasapphire: EditionGenVI,
    @Embedded(prefix = "xy_")
    val xy: EditionGenVI
)