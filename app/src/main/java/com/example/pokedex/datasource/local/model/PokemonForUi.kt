package com.example.pokedex.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO get rid of Pokemon data class and use this entity

@Entity
data class PokemonForUi(
    @PrimaryKey
    val id: Int,
    val name: String,
    val sprite: String,
    val url: String
)
