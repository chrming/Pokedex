package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GenerationIII(
    @Embedded(prefix = "emerald_")
    val emerald: Emerald?,
    @Embedded(prefix = "firered_leafgreen_")
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: EditionGenIII?,
    @Embedded(prefix = "ruby_sapphire_")
    @SerializedName("ruby-sapphire")
    val rubySapphire: EditionGenIII?
) {
    constructor() : this(Emerald(), EditionGenIII(), EditionGenIII())
}