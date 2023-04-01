package com.example.coin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coin.databinding.ItemCoinBinding
import com.example.coin.models.CoinModel

class CoinAdapter : ListAdapter<CoinModel, CoinAdapter.ViewHolder>(
    diffUtil
) {

    class ViewHolder(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CoinModel?) = with(binding) {
            tvName.text = item?.assetIdQuote
            tvNum.text = item?.rate.toString()
            tvTime.text = item?.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCoinBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CoinModel>() {
            override fun areItemsTheSame(
                oldItem: CoinModel,
                newItem: CoinModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CoinModel,
                newItem: CoinModel
            ): Boolean {
                return oldItem.rate == newItem.rate
            }
        }
    }
}