package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Sprites(
    val back_female: String?,
    val back_default: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    @Embedded
    val other: Other,
    @Embedded
    val versions: Versions
) {
    constructor() : this(
        "None",
        "None",
        "None",
        "None",
        "None",
        "None",
        "None", "None",
        Other(),
        Versions()
    )
}