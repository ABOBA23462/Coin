package com.example.coin.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.coin.data.remote.apiservice.CoinApiService
import com.example.coin.models.CoinModel
import com.example.coin.models.CoinResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val coinApiService: CoinApiService
) {
    fun fetchCoin(): MutableLiveData<CoinResponse<CoinModel>> {
        val data: MutableLiveData<CoinResponse<CoinModel>> = MutableLiveData()
        coinApiService.fetchCoin()
            .enqueue(object : Callback<CoinResponse<CoinModel>> {

                override fun onResponse(
                    call: Call<CoinResponse<CoinModel>>,
                    response: Response<CoinResponse<CoinModel>>
                ) {

                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<CoinResponse<CoinModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}