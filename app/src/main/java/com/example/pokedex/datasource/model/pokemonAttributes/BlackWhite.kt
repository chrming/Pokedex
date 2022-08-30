package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class BlackWhite(
    @Embedded(prefix = "animated_")
    val animated: Animated,
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
) {
    constructor() : this(Animated(), "None", "None", "None", "None", "None", "None", "None", "None")
}