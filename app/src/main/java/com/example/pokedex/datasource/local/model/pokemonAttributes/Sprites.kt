package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Sprites(
    val back_default: String,
    @Embedded
    val back_female: Any,
    val back_shiny: String,
    @Embedded
    val back_shiny_female: Any,
    val front_default: String,
    @Embedded
    val front_female: Any,
    val front_shiny: String,
    @Embedded
    val front_shiny_female: Any,
    @Embedded
    val other: Other,
    @Embedded
    val versions: Versions
)