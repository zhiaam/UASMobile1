package com.example.countries

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.network.Records
import com.example.countries.ui.HeritageApiStatus
import com.example.countries.ui.HeritageListAdapter

@BindingAdapter("listData2")
fun bindRecyclerView2(recyclerView: RecyclerView, data: List<Records>?) {
    val adapter2 = recyclerView.adapter as HeritageListAdapter
    adapter2.submitList(data)
}


@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: HeritageApiStatus?) {
    when(status) {
        HeritageApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        HeritageApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        HeritageApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}
