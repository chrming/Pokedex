package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo


data class  EditionGenIII(
    @ColumnInfo(name = "edition_geniii_back_default")
    val back_default: String,
    @ColumnInfo(name = "edition_geniii_back_shiny")
    val back_shiny: String,
    @ColumnInfo(name = "edition_geniii_front_default")
    val front_default: String,
    @ColumnInfo(name = "edition_geniii_front_shiny")
    val front_shiny: String
)
