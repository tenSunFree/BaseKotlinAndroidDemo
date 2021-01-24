package com.example.basekotlinandroiddemo.presentation.home.model

import com.google.gson.annotations.SerializedName

class HomeResponse : ArrayList<HomeResponse.Item>() {
    data class Item(
        @SerializedName("body")
        val body: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("userId")
        val userId: Int
    )
}

