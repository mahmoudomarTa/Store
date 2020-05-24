package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.Category
import kotlinx.android.synthetic.main.category_item_admin.view.*

class AdminHomeAdapter(var context: Context,var data:List<Category>,var onCategoryItemClickListener: OnCategoryItemClickListener):RecyclerView.Adapter<AdminHomeAdapter.AdminHomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminHomeViewHolder {
        return AdminHomeViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_admin,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AdminHomeViewHolder, position: Int) {
        holder.tvCategoryName.text=data[position].name
        holder.itemView.setOnLongClickListener {
            onCategoryItemClickListener.onItemLongClicked(data[position])
            true
        }
        holder.itemView.setOnClickListener {
            onCategoryItemClickListener.onItemClicked(data[position])
        }
        holder.imgDeleteCategory.setOnClickListener {
            onCategoryItemClickListener.onDeleteImgClicked(data[position])
        }
    }

    class AdminHomeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvCategoryName = itemView.tvCategoryName
        var imgDeleteCategory=itemView.imgDeleteCategory
    }
    interface OnCategoryItemClickListener{
        fun onItemClicked(category: Category)
        fun onItemLongClicked(category: Category)
        fun onDeleteImgClicked(category: Category)
    }
}