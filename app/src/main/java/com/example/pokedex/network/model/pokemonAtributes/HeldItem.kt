package com.example.pokedex.network.model.pokemonAtributes

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)