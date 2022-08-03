package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class BlackWhite(
    @Embedded
    val animated: Animated,
    @ColumnInfo(name = "black_white_back_default")
    val back_default: String,
    @Embedded
    val back_female: Any,
    @ColumnInfo(name = "black_white_back_shiny")
    val back_shiny: String,
    @Embedded
    val back_shiny_female: Any,
    @ColumnInfo(name = "black_white_front_default")
    val front_default: String,
    @Embedded
    val front_female: Any,
    @ColumnInfo(name = "black_white_front_shiny")
    val front_shiny: String,
    @Embedded
    val front_shiny_female: Any
)