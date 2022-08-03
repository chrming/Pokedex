package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class HeldItem(
    @Embedded
    val item: Attribute,
    @Embedded
    val version_details: List<VersionDetail>
)