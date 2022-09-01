package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationVII(
    @Embedded(prefix = "genvii_icons_")
    val icons: Icons?,
    @Embedded(prefix = "ulstrasun_ultramoon_")
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: EditionGenVII?
){
    constructor():this(Icons(), EditionGenVII())
}