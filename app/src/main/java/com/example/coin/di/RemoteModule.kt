package com.example.coin.di

import com.example.coin.data.remote.RetrofitClient
import com.example.coin.data.remote.apiservice.CoinApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    val retrofitClient: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCoinApiService(): CoinApiService {
        return retrofitClient.provideCoinApiService()
    }
}