package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class EditionGenIV(
    @ColumnInfo(name = "edition_geriv_back_default")
    val back_default: String,
    @Embedded
    val back_female: Any,
    @ColumnInfo(name = "edition_geriv_back_shiny")
    val back_shiny: String,
    @Embedded
    val back_shiny_female: Any,
    @ColumnInfo(name = "edition_geriv_front_default")
    val front_default: String,
    @Embedded
    val front_female: Any,
    @ColumnInfo(name = "edition_geriv_front_shiny")
    val front_shiny: String,
    @Embedded
    val front_shiny_female: Any
)
