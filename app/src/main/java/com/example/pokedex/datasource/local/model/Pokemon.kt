package com.example.pokedex.datasource.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.datasource.network.model.pokemonAttributes.*

@Entity
data class Pokemon(
    @Embedded
    val abilities: List<Ability>,
    val base_experience: Int,
    @Embedded
    val forms: List<Attribute>,
    @Embedded
    val game_indices: List<GameIndice>,
    val height: Int,
    @Embedded
    val held_items: List<HeldItem>,
    @PrimaryKey
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    @Embedded
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @Embedded
    val past_types: List<PastType>,
    @Embedded
    val species: Attribute,
    @Embedded
    val sprites: Sprites,
    @Embedded
    val stats: List<Stat>,
    @Embedded
    val types: List<Type>,
    val weight: Int
)
