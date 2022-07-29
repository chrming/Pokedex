package com.example.pokedex.network.model.pokemon

data class PokemonListResponse(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = Any(),
    val results: List<ResponseListItem> = emptyList()
)