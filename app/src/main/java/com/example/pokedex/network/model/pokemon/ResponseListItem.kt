package com.example.pokedex.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class ResponseListItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)