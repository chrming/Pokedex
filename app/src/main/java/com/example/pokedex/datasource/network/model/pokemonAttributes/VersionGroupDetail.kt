package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded

data class VersionGroupDetail(
    val level_learned_at: Int,
    @Embedded
    val move_learn_method: Attribute,
    @Embedded
    val version_group: Attribute
)