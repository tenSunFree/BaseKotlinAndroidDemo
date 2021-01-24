package com.example.basekotlinandroiddemo.presentation.home.common

import com.example.basekotlinandroiddemo.data.repository.home.HomeRepository
import com.example.basekotlinandroiddemo.domain.usecase.HomeUseCase
import com.example.basekotlinandroiddemo.presentation.home.viewModel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class HomeModule {

    @Provides
    fun provideTopHeadLineUseCase(repository: HomeRepository): HomeUseCase {
        return HomeUseCase(repository)
    }

    @Provides
    fun provideListNewsViewModel(useCase: HomeUseCase): HomeViewModel {
        return HomeViewModel(useCase)
    }
}