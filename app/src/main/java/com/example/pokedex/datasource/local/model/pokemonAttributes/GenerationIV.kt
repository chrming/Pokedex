package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationIV(
    @Embedded(prefix = "diamond_pearl_")
    @SerializedName("diamond-pearl")
    val diamondPearl: EditionGenIV,
    @Embedded(prefix = "heartgold_soulsilver_")
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: EditionGenIV,
    @Embedded(prefix = "platinum_")
    val platinum: EditionGenIV
)