package com.example.pokecool.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.example.pokecool.R
import dagger.android.support.DaggerAppCompatActivity

/**
 * View Class for main activity
 */

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var flPokemons : FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }
    fun setupViews(){
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val frag = PokemonListFragment()
        fragmentTransaction.replace(R.id.fl_fragment_ph, frag,"fragment_pokemonos_fl")
        fragmentTransaction.commit()
    }
    /**
     * Overrides onBack pressed.
     */
    override fun onBackPressed() {
        for(frag in supportFragmentManager.fragments){
            Log.e("frag ",""+frag.tag)
        }

        if(supportFragmentManager.fragments.size>2){
            supportFragmentManager.popBackStackImmediate()
        }else{
            finish()
            System.exit(0)
        }
    }
}