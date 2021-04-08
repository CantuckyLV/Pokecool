package com.example.pokecool.Data.Api

import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class PokeServiceImpl(private val serviceInterface: PokeService):PokeService {
    override fun getPokemon(limit : Int): Observable<PokemonListResponse> {
        return serviceInterface.getPokemon(limit)
    }
    override fun getOnePokemon(id : String):Observable<PokemonResponse>{
        return serviceInterface.getOnePokemon(id)
    }
}