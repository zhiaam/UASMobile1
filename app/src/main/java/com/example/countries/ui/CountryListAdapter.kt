package com.example.countries.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ListViewItemBinding
import com.example.countries.network.Country

class CountryListAdapter(val clickListener: CountryListener) :
    ListAdapter<Country, CountryListAdapter.CountryViewHolder>(DiffCallback) {

    class CountryViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: CountryListener, country: Country) {
            binding.country = country
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {

        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.capital == newItem.capital && oldItem.region == newItem.region && oldItem.flags == newItem.flags
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(clickListener, country)
    }
}

class CountryListener(val clickListener: (country: Country) -> Unit) {
    fun onClick(country: Country) = clickListener(country)
}