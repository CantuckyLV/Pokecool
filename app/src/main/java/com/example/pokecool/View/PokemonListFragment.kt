package com.example.pokecool.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokecool.Domain.Model.PokemonDetailed
import com.example.pokecool.Domain.Model.PokemonSprite
import com.example.pokecool.Domain.PokeRepository
import com.example.pokecool.R
import com.example.pokecool.View.Adapters.PokemonAdapter
import dagger.android.support.DaggerFragment
import java.io.Serializable
import javax.inject.Inject

/**
 * View Class for main PokemonListFragment
 */
class PokemonListFragment () : DaggerFragment() {
    /*@Inject
    lateinit var useCase: GetPokemonUseCase*/
    //private val viewModel : PokemonListViewModel by viewModels()
    //TODO DESCOMENTAR PARA DAGGER
    @Inject
   lateinit var viewModel: PokemonListViewModel

    private lateinit var  rvPokes:RecyclerView
    private  lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var  loadingView : RelativeLayout
    private var pokemonSpriteList = ArrayList<PokemonSprite>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }
    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
        viewModel.getPokemon()
        setupView()
        initAdapter()
        observeData()
    }
    override fun onDestroy() {
        viewModel.clearDisposables()
        super.onDestroy()
    }

    private fun setupView(){
        rvPokes = requireView().findViewById(R.id.rv_pokes)
        loadingView = requireView().findViewById(R.id.rl_loading)

    }
    /**
     * Initializes adapter for recyclerview
     */
    private fun initAdapter() {
        pokemonAdapter = PokemonAdapter(
            pokemonSpriteList,
            object : PokemonAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    Log.e("keloko", "" + viewModel!!.detailedPokemonList[position]!!.name)
                    ShowDetailCard(viewModel!!.detailedPokemonList[position]!!)
                }
            },
            requireActivity()
        )
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPokes.adapter = pokemonAdapter
        rvPokes.layoutManager = GridLayoutManager(activity, 3)
    }
    /**
     * Observes Livedata on the viewModel and calls reloadList() with its value
     */
    private fun observeData() {
        viewModel.pokeSpriteList.observe(viewLifecycleOwner, Observer {
            for (poke in it) {
                Log.e("poke: ", "" + poke.name)
            }
            reLoadList(it)
        })
    }
    /**
     * updates Pokemon list with new values and notifys the adapter
     * @param pokemonSprites List of sprites to be displayed
     */
    private fun reLoadList(pokemonSprites: List<PokemonSprite>){
        pokemonSpriteList.clear()
        pokemonSpriteList.addAll(pokemonSprites)
        pokemonAdapter.notifyDataSetChanged()
        loadingView.visibility = View.GONE
    }

    /**
     * shows PokemonInfo card
     * @param detailedPokemon pokemon selected by the user
     */
    private fun ShowDetailCard(detailedPokemon : PokemonDetailed){

        val bundle = Bundle()
        bundle.putSerializable("pokemonDetailed",  detailedPokemon as Serializable)
        val fragmentManager: FragmentManager? = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction =
            fragmentManager!!.beginTransaction()

        val infoFragment = PokemonInfoFragment()
        infoFragment.arguments = bundle
        fragmentTransaction.add(R.id.fl_fragment_ph,infoFragment,"fragment_info_fl")
        fragmentTransaction.addToBackStack("fragment_info_fl")
        fragmentTransaction.commit()
    }


}