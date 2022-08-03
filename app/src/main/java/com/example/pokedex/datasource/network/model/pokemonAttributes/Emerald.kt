package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo

data class Emerald(
    @ColumnInfo(name = "emerald_front_default")
    val front_default: String,
    @ColumnInfo(name = "emerald_front_shiny")
    val front_shiny: String
)