package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Sprites(
    val back_female: String? = null,
    val back_default: String? = null,
    val back_shiny: String? = null,
    val back_shiny_female: String? = null,
    val front_default: String? = null,
    val front_female: String? = null,
    val front_shiny: String? = null,
    val front_shiny_female: String? = null,
    @Embedded
    val other: Other,
    @Embedded
    val versions: Versions
)