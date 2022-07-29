package com.example.pokedex.pokemonList.useCase

data class PokemonListUseCaseWrapper(
    val getPokemonList: GetPokemonListUseCase,
    val getPokemonListItem: GetPokemonListItemUseCase
)
