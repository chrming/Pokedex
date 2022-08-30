package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class Ability(
    @Embedded
    val ability: Attribute,
    val is_hidden: Boolean,
    val slot: Int
)