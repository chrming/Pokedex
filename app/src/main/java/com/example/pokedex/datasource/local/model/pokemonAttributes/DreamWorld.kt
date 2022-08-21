package com.example.pokedex.datasource.local.model.pokemonAttributes

data class DreamWorld(
    val front_default: String?,
    val front_female: String?
){
    constructor(): this("None", "None")
}