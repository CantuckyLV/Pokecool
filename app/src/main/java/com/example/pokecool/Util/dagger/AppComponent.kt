package com.example.pokecool.Util.dagger

import android.app.Application
import com.example.pokecool.Data.Api.PokeService
import com.example.pokecool.Domain.GetPokemonUseCase
import com.example.pokecool.Domain.PokeRepository
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Component providing Application scoped instances.
 */
@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, ViewBindingModule::class,NetworkModule::class,PokemonListFragmentModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    //fun userSearchResultDataProvider(): UserSearchResultDataProvider
    //fun   pokeService() : PokeService
    fun   pokeRepository() : PokeRepository
    fun   getPokemonUseCase() : GetPokemonUseCase
    //fun   application(): Application
}