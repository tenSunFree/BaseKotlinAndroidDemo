package com.example.basekotlinandroiddemo.module

import android.content.Context
import com.example.basekotlinandroiddemo.BuildConfig
import com.example.basekotlinandroiddemo.data.dataSource.remote.home.HomeDataSource
import com.example.basekotlinandroiddemo.data.dataSource.remote.home.HomeDataSourceImpl
import com.example.basekotlinandroiddemo.data.dataSource.remote.home.HomeApiServices
import com.example.basekotlinandroiddemo.data.repository.home.HomeRepository
import com.example.basekotlinandroiddemo.data.repository.home.HomeRepositoryImpl
import com.example.corelibrary.network.NetworkChecker
import com.example.corelibrary.network.NetworkCheckerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideNewsApiServices(retrofit: Retrofit): HomeApiServices =
        retrofit.create(HomeApiServices::class.java)

    @Provides
    @Singleton
    fun provideNewsDataSource(services: HomeApiServices): HomeDataSource {
        return HomeDataSourceImpl(services)
    }

    @Provides
    @Singleton
    fun provideNetworkChecker(@ApplicationContext context: Context): NetworkChecker {
        return NetworkCheckerImpl(context)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(
        dataSource: HomeDataSource,
        networkCheck: NetworkChecker
    ): HomeRepository {
        return HomeRepositoryImpl(dataSource = dataSource, networkChecker = networkCheck)
    }
}