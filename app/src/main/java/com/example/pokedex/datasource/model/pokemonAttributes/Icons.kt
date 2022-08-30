package com.example.pokedex.datasource.model.pokemonAttributes

data class Icons(
    val front_default: String?,
    val front_female: String?
) {
    constructor() : this("None", "None")
}