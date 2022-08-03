package com.example.pokedex.pokemonList.domain.useCase

data class PokemonListUseCaseWrapper(
    val getPokemonList: GetPokemonListUseCase,
    val getPokemonListItem: GetPokemonListItemUseCase,
    val insertPokemon: InsertPokemonUseCase
)
