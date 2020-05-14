package com.example.store.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import kotlinx.android.synthetic.main.color_layout.view.*

class ColorsAdapter(
    var context: Context?,
    var colors:Array<Int>,
    var onColorSelected:OnColorSelected ): RecyclerView.Adapter<ColorsAdapter.ColorsViewHoldar>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHoldar {
       return ColorsViewHoldar(LayoutInflater.from(context).inflate(R.layout.color_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: ColorsViewHoldar, position: Int) {
        holder.viewColor.setBackgroundColor(colors[position])
        holder.itemView.setOnClickListener {
            holder.viewSelected.visibility=View.VISIBLE
            onColorSelected.onColorSelect(colors[position])
        }
    }

    class ColorsViewHoldar(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewColor = itemView.viewColor
        var viewSelected = itemView.viewSelected
    }
    interface OnColorSelected{
        fun onColorSelect(color:Int);
    }
}