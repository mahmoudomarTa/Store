package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Brand
import kotlinx.android.synthetic.main.brand_layout.view.*

class BrandAdapter(var context: Context,var brands:ArrayList<Brand>): RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder(LayoutInflater.from(context).inflate(R.layout.brand_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return brands.size
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.tvBrandName.text=brands[position].name
        holder.rbBrand.rating=brands[position].brandRait.toFloat()
    }

    class BrandViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var imgBrand = itemView.imgBrand
        var tvBrandName= itemView.tvBrandName
        var rbBrand= itemView.rbBrand
    }
}