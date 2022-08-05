package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Other(
    @Embedded
    val dream_world: DreamWorld,
    @Embedded(prefix = "home_")
    val home: Home,
    @Embedded
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)