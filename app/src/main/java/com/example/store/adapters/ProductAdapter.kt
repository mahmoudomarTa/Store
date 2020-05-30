package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.store.R
import com.example.store.adapters.HomeAdapter.OnProductClickListener
import com.example.store.model.Brand
import com.example.store.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_second.imgAboutItem
import kotlinx.android.synthetic.main.brand_layout.view.*
import kotlinx.android.synthetic.main.item_product.view.name
import java.lang.System.load

class ProductAdapter(
    var context: Context,
    var products: List<Product>,
    var onProductClickListener: com.example.store.adapters.HomeAdapter.OnProductClickListener
) :
    RecyclerView.Adapter<ProductAdapter.BrandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.rbBrand.rating = products[position].rate.toFloat()
        Glide.with(holder.itemView.context).load(products[position].img).into(holder.img)


        holder.itemView.setOnClickListener {
            onProductClickListener.onItemClicked(products[position].id,position)
        }
    }

    class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rbBrand = itemView.rbBrand
        var img = itemView.imgBrand

    }

    interface OnProductClickListener {
        fun onItemClicked(id: String);
    }
}