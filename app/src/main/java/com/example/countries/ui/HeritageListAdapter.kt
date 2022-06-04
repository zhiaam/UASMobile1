package com.example.countries.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ListViewItem2Binding
import com.example.countries.network.Records

class HeritageListAdapter(val clickListener: HeritageListener) :
    ListAdapter<Records, HeritageListAdapter.HeritageViewHolder>(DiffCallback) {

    class HeritageViewHolder(
        var binding: ListViewItem2Binding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: HeritageListener, heritage: Records) {
            binding.heritage = heritage
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Records>() {

        override fun areItemsTheSame(oldItem: Records, newItem: Records): Boolean {
            return oldItem.fields.name == newItem.fields.name
        }

        override fun areContentsTheSame(oldItem: Records, newItem: Records): Boolean {
            return oldItem.fields.description == newItem.fields.description
                    && oldItem.fields.country == newItem.fields.country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeritageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeritageViewHolder(
            ListViewItem2Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HeritageViewHolder, position: Int) {
        val heritage = getItem(position)
        holder.bind(clickListener, heritage)
    }
}

class HeritageListener(val clickListener: (heritage: Records) -> Unit) {
    fun onClick(heritage: Records) = clickListener(heritage)
}