package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class Move(
    @Embedded
    val move: Attribute,
    @Embedded
    val version_group_details: List<VersionGroupDetail>
)