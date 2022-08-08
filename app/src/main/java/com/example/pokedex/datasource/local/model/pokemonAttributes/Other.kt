package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Other(
    @Embedded(prefix = "dream_world_")
    val dream_world: DreamWorld,
    @Embedded(prefix = "home_")
    val home: Home,
    @Embedded(prefix = "official_artwork_")
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)