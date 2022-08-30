package com.example.pokedex.datasource.model.pokemonAttributes

data class Emerald(
    val front_default: String?,
    val front_shiny: String?
) {
    constructor() :this("None","None")
}