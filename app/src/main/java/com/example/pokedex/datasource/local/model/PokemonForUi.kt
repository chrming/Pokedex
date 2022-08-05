package com.example.pokedex.datasource.local.model

//TODO get rid of Pokemon data class and use this entity

data class PokemonForUi(
    val id: Int,
    val name: String,
    val sprite: String,
    val url: String
)
