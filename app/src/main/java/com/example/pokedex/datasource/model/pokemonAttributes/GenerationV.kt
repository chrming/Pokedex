package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationV(
    @Embedded(prefix = "balckwhite_")
    @SerializedName("black-white")
    val blackWhite: BlackWhite?
){
    constructor(): this(BlackWhite())
}