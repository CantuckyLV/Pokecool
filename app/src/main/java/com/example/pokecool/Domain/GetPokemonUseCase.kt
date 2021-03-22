package com.example.pokecool.Domain

import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import com.example.pokecool.Data.Response.PokemonSimple
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


/**
 * Interface for the UseCase
 */
interface  GetPokemonUseCase{
    fun getPokemon() : Observable<PokemonListResponse>?
    fun getComplexPokemon(pokemonSimpleList : List<PokemonSimple>) : Single<MutableList<PokemonResponse>>?

}