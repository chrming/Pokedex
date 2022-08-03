package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class VersionDetail(
    val rarity: Int,
    @Embedded
    val version: Attribute
)