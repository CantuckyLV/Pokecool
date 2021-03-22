package com.example.pokecool.Domain.Model
import com.example.pokecool.Data.Response.PokemonResponse
import java.io.Serializable

/**
 * POJOS representing a pokemon Sprite
 * @ModelMapper a mapper to transform from API response
 */
data class PokemonSprite(
    val id: Int = 0,
    val name: String? = "",
    val sprite: String? = ""
) : Serializable {
    object ModelMapper {
        fun from(resp: PokemonResponse) =
            PokemonSprite(resp.id, resp.name, resp.sprites!!.frontDefault)
    }
}