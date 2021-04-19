package com.example.marvel.data

import com.example.marvel.model.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApiInterface {
    @GET("/v1/public/characters?ts=1618818243&apikey=740d64e92cd381e076477a3c440e5559&hash=60e01f02050d9f7c11a9c90854679626")
    fun getCharacterList():
            Call<CharacterData>
}