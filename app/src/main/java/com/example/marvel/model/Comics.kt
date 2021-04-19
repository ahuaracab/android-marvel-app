package com.example.marvel.model
import java.io.Serializable

import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("items") val items: Items
)
