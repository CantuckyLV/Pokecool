package com.example.pokecool.Util.dagger


import com.example.pokecool.Data.Api.PokeService
import com.example.pokecool.Data.Api.PokeServiceImpl
import com.example.pokecool.Domain.GetPokemonUseCase
import com.example.pokecool.Domain.GetPokemonUseCaseImpl
import com.example.pokecool.Domain.PokeRepository
import com.example.pokecool.Domain.PokeRepositoryImpl
import com.example.pokecool.View.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module to setup Application scoped instances that require providers.
 */
@Module
abstract class AppModule {
    //@Binds
    //abstract fun provideApiService(apiImpl: PokeServiceImpl): PokeService
    @Binds
    abstract fun providePokeRepository(pokeRepoImpl: PokeRepositoryImpl): PokeRepository
    @Binds
    abstract fun provideGetPokemonUseCase(getPokemonUseCaseImpl: GetPokemonUseCaseImpl): GetPokemonUseCase
}