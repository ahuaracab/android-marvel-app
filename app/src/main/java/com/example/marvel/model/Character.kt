package com.example.marvel.model

import java.io.Serializable

data class Character(val name: String, val thumbnail: CharacterThumbnail, val comics: Comics) :
    Serializable
