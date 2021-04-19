package com.example.marvel.model

import com.google.gson.annotations.SerializedName

data class CharacterResults(
    @SerializedName("results") val characters: List<Character>
)
