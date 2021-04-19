package com.example.marvel.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }
}