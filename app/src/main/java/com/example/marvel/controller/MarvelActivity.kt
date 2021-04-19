package com.example.marvel.controller

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvel.databinding.ActivityMarvelBinding

class MarvelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val fragmentlist: Fragment =
         //   supportFragmentManager.findFragmentById(com.example.marvel.R.id.fragment_list) as CharacterListFragment
    }
}