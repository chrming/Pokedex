package com.example.pokedex.datasource.network.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Other(
    @Embedded
    val dream_world: DreamWorld,
    @Embedded
    val home: Home,
    @Embedded
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)