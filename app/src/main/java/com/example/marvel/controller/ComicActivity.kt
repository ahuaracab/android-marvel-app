package com.example.marvel.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvel.R
import com.example.marvel.databinding.ActivityComicBinding
import com.example.marvel.databinding.ActivityMarvelBinding

class ComicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val character = intent.getSerializableExtra("VARIABLE_ID") as Character
        print(character)
    }
}