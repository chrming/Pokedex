package com.example.pokedex.datasource.model.pokemonAttributes

data class EditionGenI(
    val back_default: String?,
    val back_gray: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_gray: String?,
    val front_transparent: String?
) {
    constructor() : this("None","None","None","None","None","None")
}