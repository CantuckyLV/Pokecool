package com.example.pokecool.View.ViewHolder

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokecool.R
import com.example.pokecool.View.Adapters.PokemonAdapter
/**
 * ViewHolder Class for the RecyclerViewAdapter
 */

class PokemonViewHolder(itemView: View, onItemClickListener: PokemonAdapter.OnItemClickListener) : RecyclerView.ViewHolder(itemView){

    var imageSprite: ImageView
    var pokeNumber: TextView
    var pokeName: TextView

    var onItemClickListener: PokemonAdapter.OnItemClickListener

    init {
        imageSprite = itemView.findViewById(R.id.image_sprite)
        pokeNumber = itemView.findViewById(R.id.poke_number)
        pokeName = itemView.findViewById(R.id.poke_name)
        this.onItemClickListener = onItemClickListener
        itemView.setOnClickListener(View.OnClickListener {
            onItemClickListener.onItemClick(adapterPosition)
        })
    }
}