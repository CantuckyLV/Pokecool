package com.example.pokecool.Domain

import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Interface for the UseCase
 */
interface PokeRepository {
    fun getPokemon(): Observable<PokemonListResponse>
    fun getOnePokemon(id : String): Observable<PokemonResponse>
}