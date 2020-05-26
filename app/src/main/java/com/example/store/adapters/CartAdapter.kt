package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Product
import com.example.store.model.Sale
import kotlinx.android.synthetic.main.item_in_cart_layout.view.*


class CartAdapter(
    var context: Context?, var products:ArrayList<Sale>,
    var onCountChange: OnCountChange?
): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(LayoutInflater.from(context).inflate(R.layout.item_in_cart_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.tvItemName.text=products[position].ProductName
        holder.tvPrice.text="${products[position].username}"
        holder.imgPlus.setOnClickListener {
            var count = holder.tvCount.text.toString().toInt()+1
            holder.tvCount.text="$count"
            notifyDataSetChanged()
            onCountChange!!.onPlusClicked(products[position].productRef,count)
        }
        holder.imgMinus.setOnClickListener {
            notifyDataSetChanged()

            var count = holder.tvCount.text.toString().toInt()-1
            holder.tvCount.text="$count"
            onCountChange!!.onMinusClicked(products[position].productRef,count)
        }
        holder.itemView.setOnLongClickListener {
            onCountChange!!.onItemLongClicked(position)
            true
        }

    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemInCart = itemView.imgItemInCart
        var tvItemName = itemView.tvItemName
        var tvPrice = itemView.tvPrice
        var tvCount = itemView.tvCount
        var imgPlus = itemView.imgPlus
        var imgMinus = itemView.imgMinus
    } interface OnCountChange{
        fun onPlusClicked(id:String,count : Int)
        fun onMinusClicked(id: String,count : Int)
        fun onItemLongClicked(position:Int)
    }
}
