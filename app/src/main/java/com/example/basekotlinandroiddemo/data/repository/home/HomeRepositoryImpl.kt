package com.example.basekotlinandroiddemo.data.repository.home

import com.example.basekotlinandroiddemo.data.dataSource.remote.home.HomeDataSource
import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.example.corelibrary.exception.Failure
import com.example.corelibrary.functional.Either
import com.example.corelibrary.network.NetworkChecker
import java.io.IOException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource,
    private val networkChecker: NetworkChecker
) : HomeRepository {

    override suspend fun getHomeResponse(): Either<Failure, HomeResponse> {
        return try {
            if (networkChecker.isNetworkConnected()) {
                val response = dataSource.getHomeResponse()
                Either.Right(response)
            } else {
                Either.Left(Failure.NetworkException)
            }
        } catch (ex: IOException) {
            Either.Left(Failure.ServerError)
        }
    }
}
