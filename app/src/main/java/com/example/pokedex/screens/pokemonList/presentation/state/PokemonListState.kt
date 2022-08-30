package com.example.pokedex.screens.pokemonList.presentation.state

import androidx.paging.PagingData
import com.example.pokedex.datasource.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonListState(
    val pokemonList: Flow<PagingData<Pokemon>> = emptyFlow()
)