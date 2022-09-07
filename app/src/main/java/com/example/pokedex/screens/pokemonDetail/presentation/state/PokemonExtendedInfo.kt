package com.example.pokedex.screens.pokemonDetail.presentation.state

import com.example.pokedex.datasource.model.pokemonAttributes.*

data class PokemonExtendedInfo(
    val abilities: List<Attribute> = emptyList(),
    val moves: List<Attribute> = emptyList(),
    val sprites: List<Attribute> = emptyList(),
    val location: List<Attribute> = emptyList(),
    val heldItems: List<Attribute> = emptyList(),
)