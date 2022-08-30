package com.example.pokedex.datasource.model.pokemonAttributes

data class DreamWorld(
    val front_default: String?,
    val front_female: String?
){
    constructor(): this("None", "None")
}