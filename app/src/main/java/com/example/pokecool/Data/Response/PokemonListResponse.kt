package com.example.pokecool.Data.Response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * POJOS as defined by the endpoint v2/pokemon?
 */
data class PokemonListResponse (
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: String? = "",
    @SerializedName("results")
    val results: ArrayList<PokemonSimple>? = ArrayList<PokemonSimple>(),
): Serializable

data class PokemonSimple (
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("url")
    val url: String? = ""
): Serializable