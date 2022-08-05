package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.ColumnInfo

data class OfficialArtwork(
    @ColumnInfo(name = "official_artwork_frond_default")
    val front_default: String
)