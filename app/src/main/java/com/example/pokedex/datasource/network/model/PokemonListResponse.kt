package com.example.pokedex.datasource.network.model

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResponseListItem>
)