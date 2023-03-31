package com.example.coin.models

import com.google.gson.annotations.SerializedName

data class CoinResponse<T>(
    @SerializedName("asset_id_base")
    val assetIdBase: String = "",

    @SerializedName("rates")
    val rates: List<T>?
)