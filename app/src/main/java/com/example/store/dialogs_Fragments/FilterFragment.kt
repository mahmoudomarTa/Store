package com.example.store.dialogs_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.store.R
import kotlinx.android.synthetic.main.fragment_filter.view.*

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment(var onFilter: OnFilter) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_filter, container, false)
        view.tvFilterFromLowToHigh.setOnClickListener {
            onFilter.onDataFilterd(getString(R.string.filterFromLowToHigh))
            dismiss()
        }
        view.tvFilterFromHighToLow.setOnClickListener {
            onFilter.onDataFilterd(getString(R.string.filterFromHighToLow))
            dismiss()
        }
        return view
    }
    interface OnFilter{
        fun onDataFilterd(type:String)
    }

}
