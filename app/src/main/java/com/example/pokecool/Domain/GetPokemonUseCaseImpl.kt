package com.example.pokecool.Domain

import android.util.Log
import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import com.example.pokecool.Data.Response.PokemonSimple
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.internal.operators.observable.ObservableFromIterable
import io.reactivex.schedulers.Schedulers
/**
 * Implementation of UseCase
 */
class GetPokemonUseCaseImpl : GetPokemonUseCase {

    private val  pokeRepository = PokeRepositoryImpl()
    /**
     * Invokes the getPokemon() method from Repository
     * @return Observable fro m repository
     */
    override fun getPokemon(): Observable<PokemonListResponse> {
        val result :  Observable<PokemonListResponse> = pokeRepository.getPokemon()
        return result
    }

    /**
     * Invokes the getOnePokemon() method from Repository for every element of the pokemonSimpleList
     * @param pokemonSimpleList List of PokemonSimple
     * @return Observable from all the responses combined into a list
     */
    override fun getComplexPokemon(pokemonSimpleList : List<PokemonSimple>): Single<MutableList<PokemonResponse>>? {
        //https://pokeapi.co/api/v2/pokemon/323/
        val tmpObservable = Observable.just(pokemonSimpleList).flatMapIterable { it -> it}.flatMap { it -> pokeRepository.getOnePokemon(it.url!!.toString()) }.subscribeOn(Schedulers.io()).toList()
        return tmpObservable
    }

}