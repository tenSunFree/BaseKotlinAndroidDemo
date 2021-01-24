package com.example.basekotlinandroiddemo.domain.usecase

import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.example.basekotlinandroiddemo.data.repository.home.HomeRepository
import com.example.corelibrary.exception.Failure
import com.example.corelibrary.functional.Either
import com.example.corelibrary.usecase.UseCase
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val repository: HomeRepository) :
    UseCase<HomeResponse, HomeUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, HomeResponse> {
        return repository.getHomeResponse()
    }

    data class Params(val temporary: String = "")
}