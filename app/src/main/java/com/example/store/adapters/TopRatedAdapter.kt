package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Product
import kotlinx.android.synthetic.main.top_rated_item_layout.view.*

class TopRatedAdapter(var context: Context?, var data:ArrayList<Product>):RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(LayoutInflater.from(context).inflate(R.layout.top_rated_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.tv_Item_top_rated.text=data[position].name
        holder.tv_rate.text=data[position].rate.toString()
        holder.rbTop.rating=data[position].rate.toFloat()

    }

    class TopRatedViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var  tv_Item_top_rated = itemView.tv_Item_top_rated
        var  rbTop = itemView.rbTop
        var  tv_rate = itemView.tv_rate
    }
}

