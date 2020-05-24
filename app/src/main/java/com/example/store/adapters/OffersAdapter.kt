package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Product
import kotlinx.android.synthetic.main.offer_item_layout.view.*

class OffersAdapter(
    var context: Context?,
    var producs:ArrayList<Product>,
    var onOfferClickListener:OnOfferClickListener): RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        return OffersViewHolder(LayoutInflater.from(context).inflate(R.layout.offer_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return producs.size
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        holder.tvDiscount.text=producs[position].discount.toString()
        holder.tvOfferName.text=producs[position].name
        holder.itemView.setOnClickListener {
            onOfferClickListener.onOfferClicked(producs[position].id!!)
        }
    }

    class OffersViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var tvDiscount = itemView.tvDiscount
        var imgOffer = itemView.imgOffer
        var tvOfferName = itemView.tvOfferName
    }

    interface OnOfferClickListener{
        fun onOfferClicked(id:String)
    }

}