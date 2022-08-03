package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class EditionGenVI(
    @ColumnInfo(name = "edition_genvi_front_default")
    val front_default: String,
    @Embedded
    val front_female: Any,
    @ColumnInfo(name = "edition_genvi_front_shiny")
    val front_shiny: String,
    @Embedded
    val front_shiny_female: Any
)