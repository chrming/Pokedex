package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Move(
    @Embedded
    val move: Attribute,
    val version_group_details: List<VersionGroupDetail>
)