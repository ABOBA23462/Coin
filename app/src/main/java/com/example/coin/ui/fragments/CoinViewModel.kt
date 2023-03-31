package com.example.coin.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.coin.data.repositories.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : ViewModel() {

    fun fetchCoin() = coinRepository.fetchCoin()
}