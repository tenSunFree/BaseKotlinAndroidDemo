package com.example.basekotlinandroiddemo.data.dataSource.remote.home

import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse

interface HomeDataSource {

    suspend fun getHomeResponse(): HomeResponse
}