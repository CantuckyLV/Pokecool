package com.example.pokecool.Data.Response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * POJOS as defined by the endpoint v2/pokemon?
 */
data class PokemonResponse (
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("weight")
    val weight: Int = 0,
    @SerializedName("sprites")
    val sprites: Sprite? = null,
    @SerializedName("types")
    val types: List<TypesExtra>? = null,
): Serializable

data class Sprite (
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("other")
    val other: Other? = null
): Serializable

data class Other (
    @SerializedName("official-artwork")
    val officialArtwork: OfArt? = null,
): Serializable

data class OfArt (
    @SerializedName("front_default")
    val ofFrontDefault: String = ""
): Serializable
data class TypesExtra (
    @SerializedName("slot")
    val slot: Int = 0,
    @SerializedName("type")
    val type: TypeN? = null
): Serializable
data class TypeN (
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = ""
): Serializable