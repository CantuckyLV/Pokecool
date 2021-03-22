package com.example.pokecool

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.pokecool.Data.Response.PokemonListResponse
import com.example.pokecool.Data.Response.PokemonResponse
import com.example.pokecool.Data.Response.PokemonSimple
import com.example.pokecool.Domain.Model.PokemonSprite
import com.example.pokecool.View.PokemonListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.ArrayList

@RunWith(MockitoJUnitRunner::class)
class CommitsFragmentViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    private lateinit var pokemonListViewModel: PokemonListViewModel
    private val testList = ArrayList<PokemonSprite>()
    @Mock
    private lateinit var observer: Observer<List<PokemonSprite>>
    @Before
    fun beforeTest() {
        pokemonListViewModel = PokemonListViewModel()
        pokemonListViewModel.pokeSpriteList.observeForever(observer!!)
        testList.add(
            PokemonSprite(1,"test1","url1")
        )
        testList.add(
            PokemonSprite(1,"test1","url1")
        )
    }
    @Test
    fun loadCommitsTest() {
        pokemonListViewModel.getComplexPokemon(testList)
        val captor = ArgumentCaptor.forClass(List::class.java)
        captor.run {
            Mockito.verify(observer).onChanged(capture() as List<PokemonSprite>?)
        }
    }
}