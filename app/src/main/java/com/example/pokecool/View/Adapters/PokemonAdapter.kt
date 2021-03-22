package com.example.pokecool.View.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokecool.Domain.Model.PokemonSprite
import com.example.pokecool.R
import com.example.pokecool.View.ViewHolder.PokemonViewHolder
import java.util.ArrayList

/**
 * Adapter for the RecyclerView of Pokemon
 */

class PokemonAdapter(commits: ArrayList<PokemonSprite>, mOnItemClickListener: OnItemClickListener, context: Context): RecyclerView.Adapter<PokemonViewHolder>() {
    private val pokemonList: ArrayList<PokemonSprite>? = commits
    private val mOnItemClickListener: OnItemClickListener? = mOnItemClickListener
    private val context : Context = context

    /**
     * interface that allows the Recyclerview item to listen for clicks
     */
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(itemView, mOnItemClickListener!!)
    }

    override fun getItemCount(): Int {
        return pokemonList!!.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList!![position]
        val imageSprite = holder.imageSprite
        val pokeNumber= holder.pokeNumber
        val pokeName= holder.pokeName
        Glide.with(context).load(pokemon.sprite).into(imageSprite)
        pokeNumber.text = pokemon.id.toString()
        pokeName.text = pokemon.name

    }
}