package com.example.pokecool.View.Factory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokecool.Domain.GetPokemonUseCase

/**
 * Factory Class for PokemonListViewModel not currently in use
 */
class PokemonListViewModelFactory (val getPokemonUseCase: GetPokemonUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return   modelClass.getConstructor(com.example.pokecool.Domain.GetPokemonUseCase::class.java).newInstance(getPokemonUseCase)
    }
}