package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Category
import kotlinx.android.synthetic.main.category_item.view.*

class categoriesAdapter(var context: Context?, var categories:ArrayList<Category>): RecyclerView.Adapter<categoriesAdapter.categoriesAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriesAdapterViewHolder {
        return categoriesAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item,parent,false))
    }

    override fun getItemCount(): Int {
       return categories.size
    }

    override fun onBindViewHolder(holder: categoriesAdapterViewHolder, position: Int) {
        holder.tvCategoryName.text=categories[position].name
        //Glide.with(holder.imgCategory).load(categories[position].img).into(holder.imgCategory)
    }

    class categoriesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCategory = itemView.imgCategory
        var tvCategoryName = itemView.tvCategoryName
    }
}