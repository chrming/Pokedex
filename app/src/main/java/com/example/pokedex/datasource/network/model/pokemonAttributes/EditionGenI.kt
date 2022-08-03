package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo

data class EditionGenI(
    @ColumnInfo(name = "edition_geni_back_default")
    val back_default: String,
    @ColumnInfo(name = "edition_geni_back_gray")
    val back_gray: String,
    @ColumnInfo(name = "edition_geni_front_default")
    val front_default: String,
    @ColumnInfo(name = "edition_geni_front_gray")
    val front_gray: String
)