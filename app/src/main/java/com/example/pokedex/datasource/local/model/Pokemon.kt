package com.example.pokedex.datasource.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokedex.datasource.local.model.pokemonAttributes.*

@Entity
@TypeConverters
data class Pokemon(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Attribute>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    @PrimaryKey
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_types: List<PastType>,
    @Embedded(prefix = "species_")
    val species: Attribute,
    @Embedded
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)
