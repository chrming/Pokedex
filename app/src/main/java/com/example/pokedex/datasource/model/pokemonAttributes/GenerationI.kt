package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationI(
    @Embedded(prefix = "red_blue_")
    @SerializedName("red-blue")
    val redBlue: EditionGenI,
    @Embedded(prefix = "yellow_")
    val yellow: EditionGenI
) {
    constructor() : this(EditionGenI(), EditionGenI())
}