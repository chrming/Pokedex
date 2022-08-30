package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class HeldItem(
    @Embedded
    val item: Attribute,
    val version_details: List<VersionDetail>
)