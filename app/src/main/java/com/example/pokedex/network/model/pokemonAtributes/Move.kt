package com.example.pokedex.network.model.pokemonAtributes

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)