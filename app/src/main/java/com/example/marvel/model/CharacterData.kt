package com.example.marvel.model

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("data") val results: CharacterResults
)
