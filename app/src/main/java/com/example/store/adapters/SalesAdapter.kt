package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Sale
import kotlinx.android.synthetic.main.sale_item_layout.view.*

class SalesAdapter(var context: Context?, var data:List<Sale>):RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        return SalesViewHolder(LayoutInflater.from(context).inflate(R.layout.sale_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.tvCustomerName.text=data[position].buyerEmail
        holder.tv_product_sale_name.text=data[position].buyerEmail
    }
    class SalesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tv_product_sale_name = itemView.tv_product_sale_name
        var tvCustomerName = itemView.tvCustomerName

    }
}