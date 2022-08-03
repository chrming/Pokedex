package com.example.pokedex.pokemonList.domain.useCase

data class PokemonListUseCaseWrapper(
    val getPokemonList: GetPokemonListUseCase,
    val getPokemon: GetPokemonUseCase,
    val insertPokemon: InsertPokemonUseCase,
    val deletePokemonUseCase: DeletePokemonUseCase
)
