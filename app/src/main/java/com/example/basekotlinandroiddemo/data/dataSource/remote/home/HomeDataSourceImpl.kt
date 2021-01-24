package com.example.basekotlinandroiddemo.data.dataSource.remote.home

import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val services: HomeApiServices
) : HomeDataSource {

    override suspend fun getHomeResponse(): HomeResponse {
        return services.getTopHeadlines2()
    }
}