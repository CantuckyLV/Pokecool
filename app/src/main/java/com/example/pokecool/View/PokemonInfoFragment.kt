package com.example.pokecool.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokecool.Domain.Model.PokemonDetailed
import com.example.pokecool.R
import java.lang.StringBuilder

/**
 * View Class for main PokemonInfoFragment
 */
class PokemonInfoFragment : Fragment() {
    private lateinit var  pokemonDetail : PokemonDetailed
    private lateinit var tvPokemonDexNum : TextView
    private lateinit var tvPokemonDexName : TextView
    private lateinit var tvDexTypes: TextView
    private lateinit var tvDexHeight: TextView
    private lateinit var tvDexWeight: TextView
    private lateinit var imageArt : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_info, container, false)
    }

    /**
     * Retrives pokemon info from bundle and displays it
     */
    override fun onResume() {
        super.onResume()
        tvPokemonDexName = requireView().findViewById(R.id.tv_pokemon_dexName)
        tvPokemonDexNum = requireView().findViewById(R.id.tv_pokemon_dexNum)
        tvDexTypes = requireView().findViewById(R.id.tv_dex_types)
        tvDexHeight = requireView().findViewById(R.id.tv_dex_height)
        tvDexWeight = requireView().findViewById(R.id.tv_dex_weight)
        imageArt = requireView().findViewById(R.id.image_art)
        pokemonDetail = requireArguments().getSerializable("pokemonDetailed") as PokemonDetailed
        var typesStrBuilder = StringBuilder()
        for(type in pokemonDetail.types!!){
            typesStrBuilder.append(type.type!!.name+",")
        }
        tvPokemonDexName.text = pokemonDetail.name
        tvPokemonDexNum.text = pokemonDetail.id.toString()
        Glide.with(requireActivity().applicationContext).load(pokemonDetail.sprites).into(imageArt)
        tvDexTypes.text = typesStrBuilder.toString()
        tvDexHeight.text = pokemonDetail.height.toString()
        tvDexWeight.text = pokemonDetail.weight.toString()
    }
}