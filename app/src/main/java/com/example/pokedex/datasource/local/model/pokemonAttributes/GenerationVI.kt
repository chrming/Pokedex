package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationVI(
    @Embedded(prefix = "omegaruby_alphasapphire_")
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: EditionGenVI,
    @Embedded(prefix = "xy_")
    @SerializedName("x-y")
    val xy: EditionGenVI
){
    constructor(): this(EditionGenVI(), EditionGenVI())
}