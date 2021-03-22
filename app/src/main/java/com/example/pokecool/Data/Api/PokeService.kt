package com.example.pokecool.Data.Api

import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface for retrofit builder, contains the API calls that the app will perform
 */
interface  PokeService {
        //base url https://pokeapi.co/api/
        @GET("v2/pokemon?")
        fun getPokemon(@Query("limit") limit : Int): Observable<PokemonListResponse>
        @GET("v2/pokemon/{id}")
        fun getOnePokemon(@Path("id") id : String): Observable<PokemonResponse>
}