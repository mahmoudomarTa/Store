package com.example.store.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.store.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(internal var ids: IntArray) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.imageViewBackground.setImageResource(ids[position])
    }

    override fun getCount(): Int {
        return ids.size
    }

    inner class SliderAdapterVH(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageViewBackground: ImageView
        init {
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider)

        }
    }
}