package com.example.pokedex.datasource.model.pokemonAttributes

data class Home(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
) {
    constructor() : this("None", "None", "None", "None")
}