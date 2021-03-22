package com.example.pokecool.View

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import com.example.pokecool.Data.Response.PokemonSimple
import com.example.pokecool.Domain.GetPokemonUseCaseImpl
import com.example.pokecool.Domain.Model.PokemonDetailed
import com.example.pokecool.Domain.Model.PokemonSprite
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * ViewModel Class for main PokemonListFragment
 */
class PokemonListViewModel  : ViewModel() {
    private val disposables = CompositeDisposable()
    private val getPokemonUseCase = GetPokemonUseCaseImpl()
    val detailedPokemonList = ArrayList<PokemonDetailed>()

    val pokeSpriteList = MutableLiveData<List<PokemonSprite>>()

    /**
     * Calls the getPokemon() method on the useCase and calls getComplexPokemons() with result
     */

    @SuppressLint("CheckResult")
    fun getPokemon() {
        getPokemonUseCase.getPokemon()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<PokemonListResponse?> {
                override fun onSubscribe(d: Disposable) {
                    disposables.add(d)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

                override fun onNext(t: PokemonListResponse) {
                    getComplexPokemons(t)
                }

                override fun onComplete() {
                }
            })

    }
    /**
     * Calls the getComplexPokemon() method on the useCase and updates the live data with result and stores a list of detailed pokemon
     */
    fun getComplexPokemons(pokemonListResponse: PokemonListResponse){
        getPokemonUseCase.getComplexPokemon(pokemonListResponse.results!!)!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<MutableList<PokemonResponse>> {
                override fun onSubscribe(d: Disposable) {
                    disposables.add(d)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

                override fun onSuccess(t: MutableList<PokemonResponse>) {
                    val tmpList = ArrayList<PokemonSprite>(t.size)
                    var tmpSprite = PokemonSprite()
                    var tmpDetailed = PokemonDetailed()
                    for(poke in t){
                        tmpSprite = PokemonSprite.ModelMapper.from(poke)
                        tmpDetailed = PokemonDetailed.ModelMapper.from(poke)
                        tmpList.add(tmpSprite)
                        detailedPokemonList.add(tmpDetailed)
                    }
                    pokeSpriteList.value = tmpList
                }
            })
    }
    fun getComplexPokemon(pokemonSprites : ArrayList<PokemonSprite>) {
        pokeSpriteList.value = pokemonSprites

    }

    fun clearDisposables() {
        disposables.clear()
    }
}