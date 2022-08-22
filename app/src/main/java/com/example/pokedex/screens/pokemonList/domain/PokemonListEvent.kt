package com.example.pokedex.screens.pokemonList.domain

import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter

sealed class PokemonListEvent {
    sealed class FilterEvent : PokemonListEvent() {
        data class FilterBy(val filter: Filter, val filterName: String) : FilterEvent()
        data class FilterExpanded(val filterType: Filter) : FilterEvent()
    }
}
