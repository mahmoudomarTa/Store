package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.adapters.HomeAdapter.OnProductClickListener
import com.example.store.model.Brand
import com.example.store.model.Product
import kotlinx.android.synthetic.main.brand_layout.view.*
import kotlinx.android.synthetic.main.item_product.view.name

class ProductAdapter(var context: Context, var products: List<Product> , var onProductClickListener: com.example.store.adapters.HomeAdapter.OnProductClickListener) :
    RecyclerView.Adapter<ProductAdapter.BrandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.rbBrand.name.text = products[position].name.toString()


        holder.itemView.setOnClickListener {
            onProductClickListener.onItemClicked(products[position].id)
        }


    }

    class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rbBrand = itemView.name
    }


    interface OnProductClickListener{
        fun onItemClicked(id:String);
    }



}