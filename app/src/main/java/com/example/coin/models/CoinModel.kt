package com.example.coin.models

import com.google.gson.annotations.SerializedName

data class CoinModel(
    @SerializedName("rate")
    val rate: Double = 0.0,

    @SerializedName("asset_id_quote")
    val assetIdQuote: String = "",

    @SerializedName("time")
    val time: String = ""
)