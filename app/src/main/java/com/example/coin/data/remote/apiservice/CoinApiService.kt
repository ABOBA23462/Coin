package com.example.coin.data.remote.apiservice

import com.example.coin.models.CoinModel
import com.example.coin.models.CoinResponse
import retrofit2.Call
import retrofit2.http.GET

interface CoinApiService {
    @GET("https://rest.coinapi.io/v1/exchangerate/BTC?apikey=B0F8AD58-369C-4496-8FF1-68E49F0B406B")
     fun fetchCoin(
    ): Call<CoinResponse<CoinModel>>
}