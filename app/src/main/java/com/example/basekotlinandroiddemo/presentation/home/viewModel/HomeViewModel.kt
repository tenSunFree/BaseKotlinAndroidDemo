package com.example.basekotlinandroiddemo.presentation.home.viewModel

import androidx.lifecycle.viewModelScope
import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.example.basekotlinandroiddemo.domain.usecase.HomeUseCase
import com.example.corelibrary.BaseViewModel
import com.example.corelibrary.exception.Failure
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val useCase: HomeUseCase) :
    BaseViewModel<HomeViewModel.ViewState>() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(val response: HomeResponse) : ViewState()
        data class Error(val message: String) : ViewState()
    }

    fun getHomeResponse() {
        viewModelScope.launch {
            viewState.postValue(ViewState.Loading)
            val result = useCase.run(HomeUseCase.Params())
            result.fold({ failure ->
                when (failure) {
                    is Failure.ServerError -> {
                        viewState.postValue(ViewState.Error("Server error"))
                    }
                    is Failure.NetworkException -> {
                        viewState.postValue(ViewState.Error("Network error"))
                    }
                    else -> viewState.postValue(ViewState.Error("Network error"))
                }
            }, { response ->
                if (!response.isNullOrEmpty()) {
                    viewState.postValue(ViewState.Success(response))
                }
            })
        }
    }
}