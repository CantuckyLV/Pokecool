package com.example.pokecool.Domain.Model

import com.example.pokecool.Data.Response.PokemonResponse
import com.example.pokecool.Data.Response.Sprite
import com.example.pokecool.Data.Response.TypesExtra
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * POJOS representing a pokemon Sprite
 * @ModelMapper a mapper to transform from API response
 */
data class PokemonDetailed(
    val id: Int = 0,
    val name: String? = "",
    val height: Int = 0,
    val weight: Int = 0,
    val sprites: String? = null,
    val types: List<TypesExtra>? = null,
) : Serializable {
    object ModelMapper {
        fun from(resp: PokemonResponse) =
            PokemonDetailed(resp.id, resp.name, resp.height,resp.weight,resp.sprites!!.other!!.officialArtwork!!.ofFrontDefault,resp.types)
    }
}