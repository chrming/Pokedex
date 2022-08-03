package com.example.pokedex.datasource.network.model.pokemon

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonListResponse(
    val count: Int,
    @PrimaryKey //TODO need only one instance of PokemonListResponse
    val next: String,
    @Embedded
    val previous: Any,
    @Embedded
    val results: List<ResponseListItem>
)