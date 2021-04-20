package com.example.marvel.controller

import RVComicAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.databinding.ActivityComicBinding
import com.example.marvel.model.Character


class ComicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val character = intent.getSerializableExtra("VARIABLE_ID") as Character
        print(character)

        binding.rvComics.adapter = RVComicAdapter(character.comics.items) {

        }
        binding.rvComics.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}