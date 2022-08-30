package com.example.pokedex.screens.home.domain.state

import com.example.pokedex.datasource.model.Pokemon

data class PokemonState(
    val pokemon: Pokemon = Pokemon()
)