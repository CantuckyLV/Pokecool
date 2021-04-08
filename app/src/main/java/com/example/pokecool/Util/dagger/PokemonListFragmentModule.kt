package com.example.pokecool.Util.dagger

import com.example.pokecool.Domain.GetPokemonUseCase
import com.example.pokecool.View.PokemonListViewModel
import dagger.Module
import dagger.Provides

@Module
class PokemonListFragmentModule {
    @Provides
    fun providePokemonListViewModel(pokemonUseCase: GetPokemonUseCase)
            = PokemonListViewModel(pokemonUseCase)
}