package com.example.pokecool.Util.dagger
//import com.slack.exercise.ui.usersearch.UserSearchActivity
//import com.slack.exercise.ui.usersearch.UserSearchFragment
import com.example.pokecool.View.MainActivity
import com.example.pokecool.View.PokemonInfoFragment
import com.example.pokecool.View.PokemonListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module to declare UI components that have injectable members
 */
@Module
abstract class ViewBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindPokemonListFragment(): PokemonListFragment

    @ContributesAndroidInjector
    abstract fun bindPokemonInfoFragment(): PokemonInfoFragment
}