package com.example.soalmandirifeandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soalmandirifeandroid.R
import com.example.soalmandirifeandroid.entity.ResultsItem

class AdapterDiscoveryMovies : RecyclerView.Adapter<AdapterDiscoveryMovies.VH>() {
    private val list = arrayListOf<ResultsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDiscoveryMovies.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_discovery_movies,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterDiscoveryMovies.VH, position: Int) {
        val items = list[position]
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view)

    internal fun addList(mList: ArrayList<ResultsItem>) {
        list.addAll(mList)
        if (list.size > 0) {
            notifyItemInserted(list.size)
        } else {
            notifyDataSetChanged()
        }
    }

    internal fun clearList() {
        list.clear()
        notifyDataSetChanged()
    }
}