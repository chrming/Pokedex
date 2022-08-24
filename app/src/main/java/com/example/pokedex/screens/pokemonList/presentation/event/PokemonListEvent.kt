package com.example.pokedex.screens.pokemonList.presentation.event

sealed class PokemonListEvent {
    sealed class FilterEvent : PokemonListEvent() {
        sealed class Version() : FilterEvent() {
            data class FilterExpanded(val expanded: Boolean) : Version()
            data class FilterSelected(val filterName: String) : Version()
        }

        sealed class Type() : FilterEvent() {
            data class FilterExpanded(val expanded: Boolean) : Type()
            data class FilterSelected(val filterName: String) : Type()
        }

        sealed class Name() : FilterEvent() {
            data class OnChange(val filterName: String) : Name()
        }

        object ToggleFilterSection: FilterEvent()
    }
}