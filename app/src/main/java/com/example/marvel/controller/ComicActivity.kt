package com.example.marvel.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel.databinding.ActivityComicBinding
import com.example.marvel.model.Character
import com.example.marvel.model.Items


class ComicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val comic = intent.getSerializableExtra("VARIABLE_ID") as List<Items>

    }
}