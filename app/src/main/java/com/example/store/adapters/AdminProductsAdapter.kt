package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Product
import kotlinx.android.synthetic.main.product_item_layout.view.*


class AdminProductsAdapter(var context: Context,var data:ArrayList<Product>,var onProductClickListener: OnProductClickListener):RecyclerView.Adapter<AdminProductsAdapter.AdminProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminProductsViewHolder {
        return AdminProductsViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdminProductsViewHolder, position: Int) {
        holder.tvProductName.text=data[position].name
        holder.imgEdit.setOnClickListener {
            onProductClickListener.onEditClicked(data[position])
        }

        holder.imgDeleteProduct.setOnClickListener {
            onProductClickListener.onDeleteClicked(data[position])
        }
        holder.itemView.setOnClickListener {
            onProductClickListener.onProductClicked(data[position])
        }

    }

    class AdminProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvProductName = itemView.tvProductName
        var imgDeleteProduct = itemView.imgDeleteProduct
        var imgEdit = itemView.imgEdit
    }
    interface OnProductClickListener{
        fun onProductClicked(product: Product)
        fun onEditClicked(product: Product)
        fun onDeleteClicked(product: Product)
    }

}