package com.example.pokecool.Domain

import android.util.Log
import com.example.pokecool.Data.Api.PokeService
import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Implementation of UseCase
 */
class PokeRepositoryImpl  : PokeRepository {
    companion object{
        /**
         * Initialize retrofit service instance and variables
         */
        protected val gson = GsonBuilder()
            .setLenient()
            .create()
        protected val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
       protected val serv = retrofit.create(PokeService::class.java)
        fun getService() : PokeService{
            return serv
        }

    }
    /**
     * Invokes the getPokemon() method from PokeService
     * @return Observable from response
     */
    override fun getPokemon(): Observable<PokemonListResponse> {
        //898
        return getService().getPokemon(151)
    }

    /**
     * Invokes the getOnePokemon() method from PokeService
     * @return Observable from response
     */
    override fun getOnePokemon(id : String): Observable<PokemonResponse> {
        val subs = id.replace("https://pokeapi.co/api/v2/pokemon/","")
        return getService().getOnePokemon(subs)
    }
}