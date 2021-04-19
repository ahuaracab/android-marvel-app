package com.example.marvel.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.Character
import com.squareup.picasso.Picasso

class RVCharacterAdapter(
    private val characterList: List<Character>, val onComicClick: (Character) -> Unit
) : RecyclerView.Adapter<RVCharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)
    }

    override fun getItemCount() = characterList.size

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            itemView.findViewById<ImageView>(R.id.img_arrow).setOnClickListener {
                onComicClick(character)
                //val txtComicName = itemView.findViewById<TextView>(R.id.txt_comic_name)
               // val txtComicUrl = itemView.findViewById<TextView>(R.id.txt_comic_url)

                //txtComicName.text = character.comics.items.name
                //txtComicUrl.text = character.comics.items.resourceURI

            }
            val txtCharacterName = itemView.findViewById<TextView>(R.id.txt_character_name)

            val imgCharacter = itemView.findViewById<ImageView>(R.id.img_character)
            txtCharacterName.text = character.name
            Picasso.get()
                .load(character.thumbnail.path + "."+ character.thumbnail.extension)
                .into(imgCharacter);

        }
    }
}