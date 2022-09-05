package com.example.pokedex.screens.pokemonDetail.state

import com.example.pokedex.datasource.model.Pokemon

data class PokemonState(
    val pokemon: Pokemon = Pokemon(),
    val expanded: ExpandedState = ExpandedState()
)