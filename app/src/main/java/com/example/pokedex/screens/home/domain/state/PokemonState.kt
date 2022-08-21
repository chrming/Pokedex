package com.example.pokedex.screens.home.domain.state

import com.example.pokedex.datasource.local.model.Pokemon

data class PokemonState(
    val pokemon: Pokemon = Pokemon()
)