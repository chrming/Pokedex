package com.example.pokedex.datasource.model.pokemonAttributes


data class  EditionGenIII(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?
) {
    constructor() :this("None","None","None","None")
}
