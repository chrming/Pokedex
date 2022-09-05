package com.example.pokedex.screens.pokemonDetail.presentation.event

sealed class PokemonDetailEvent {
    sealed class Expanded : PokemonDetailEvent(){
         object Abilities : Expanded()
         object Moves : Expanded()
         object HeldItem : Expanded()
         object AreaEncounter : Expanded()
         object Sprites : Expanded()
    }
}