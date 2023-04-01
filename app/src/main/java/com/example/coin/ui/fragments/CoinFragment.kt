package com.example.coin.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coin.R
import com.example.coin.base.BaseFragment
import com.example.coin.databinding.FragmentCoinBinding
import com.example.coin.ui.adapter.CoinAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinFragment : BaseFragment<FragmentCoinBinding, CoinViewModel>(R.layout.fragment_coin) {

    override val binding by viewBinding(FragmentCoinBinding::bind)
    override val viewModel: CoinViewModel by viewModels()
    private val coinAdapter = CoinAdapter()

    override fun initialize() {
        binding.rvCoin.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coinAdapter
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchCoin().observe(viewLifecycleOwner) {
                coinAdapter.submitList(it.rates)
            }
        }
    }
}