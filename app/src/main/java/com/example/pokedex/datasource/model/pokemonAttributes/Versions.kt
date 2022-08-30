package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Versions(
    @Embedded
    @SerializedName("generation-i")
    val generationI: GenerationI,
    @Embedded
    @SerializedName("generation-ii")
    val generationII: GenerationII,
    @Embedded
    @SerializedName("generation-iii")
    val generationIII: GenerationIII,
    @Embedded
    @SerializedName("generation-iv")
    val generationIV: GenerationIV,
    @Embedded
    @SerializedName("generation-v")
    val generationV: GenerationV,
    @Embedded
    @SerializedName("generation-vi")
    val generationVI: GenerationVI,
    @Embedded
    @SerializedName("generation-vii")
    val generationVII: GenerationVII,
    @Embedded
    @SerializedName("generation-viii")
    val generationVIII: GenerationVIII
) {
    constructor() : this(
        GenerationI(),
        GenerationII(),
        GenerationIII(),
        GenerationIV(),
        GenerationV(),
        GenerationVI(),
        GenerationVII(),
        GenerationVIII()
    )
}