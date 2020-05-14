package com.example.store.dialogs_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.store.R
import com.example.store.model.Category
import com.example.store.model.Product
import kotlinx.android.synthetic.main.fragment_update.view.*

/**
 * A simple [Fragment] subclass.
 */
class UpdateFragment(var onUpdate: OnUpdate) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_update, container, false)
        view.btnSave.setOnClickListener {
            onUpdate.onUpdate(view.edName.text.toString())
            dismiss()
        }
        view.btnCancel.setOnClickListener {
            dismiss()
        }

        return view
    }
    interface OnUpdate{
        fun onUpdate(newString: String)
    }

}
