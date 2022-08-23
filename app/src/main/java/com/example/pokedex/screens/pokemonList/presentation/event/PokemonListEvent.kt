package com.example.pokedex.screens.pokemonList.presentation.event

sealed class PokemonListEvent {
    sealed class FilterEvent : PokemonListEvent() {
        sealed class Version() : FilterEvent() {
            data class FilterExpanded(val expanded: Boolean) : Version()
            data class FilterSelected(val filterName: String) : Version()
        }

        sealed class Type() : FilterEvent() {
            data class FilterExpanded(val expanded: Boolean) : Version()
            data class FilterSelected(val filterName: String) : Version()
        }
    }
}