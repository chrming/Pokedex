package com.example.pokedex.screens.pokemonDetail.state

data class ExpandedState(
    val abilities: Boolean = false,
    val moves: Boolean = false,
    val heldItem: Boolean = false,
    val areaEncounter : Boolean= false,
    val sprites: Boolean = false
)
