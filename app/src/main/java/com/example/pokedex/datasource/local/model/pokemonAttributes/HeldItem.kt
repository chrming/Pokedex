package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class HeldItem(
    @Embedded
    val item: Attribute,
    val version_details: List<VersionDetail>
)