package com.example.basekotlinandroiddemo.data.repository.home

import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.example.corelibrary.exception.Failure
import com.example.corelibrary.functional.Either

interface HomeRepository {

    suspend fun getHomeResponse(): Either<Failure, HomeResponse>
}