package com.example.basekotlinandroiddemo.data.dataSource.remote.home

import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import retrofit2.http.GET

interface HomeApiServices {

    @GET("posts")
    suspend fun getTopHeadlines2(): HomeResponse
}