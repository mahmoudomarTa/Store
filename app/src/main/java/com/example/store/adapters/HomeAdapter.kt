package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.store.R
import com.example.store.model.Product
import kotlinx.android.synthetic.main.item_in_home_rv.view.*

class HomeAdapter(var context: Context?, var products:List<Product>,var onProductClickListener: OnProductClickListener): RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        return HomeAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_in_home_rv,parent,false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.tvPriceInHome.text=products[position].name
        holder.tvRate.text=products[position].rate.toString()
        holder.itemView.setOnClickListener {
            onProductClickListener.onItemClicked(products[position].id!!,position)
        }
        Glide.with(holder.imgItemInHome).load(products[position].img).into(holder.imgItemInHome)
    }

    inner class HomeAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemInHome = itemView.imgItemInHome
        var tvPriceInHome = itemView.tvPriceInHome
        var tvRate = itemView.tvRate
    }
    interface OnProductClickListener{
        fun onItemClicked(id:String,position: Int);
    }
}