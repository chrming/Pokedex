package com.example.pokedex.screens.pokemonDetail.state

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonExtendedInfo
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonStats

data class PokemonState(
    val pokemon: Pokemon = Pokemon(),
    val expanded: ExpandedState = ExpandedState(),
    val info: PokemonExtendedInfo = PokemonExtendedInfo(),
    val stats: PokemonStats = PokemonStats()
)