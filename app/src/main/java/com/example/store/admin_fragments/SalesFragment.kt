package com.example.store.admin_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.store.R
import com.example.store.adapters.SalesAdapter
import com.example.store.model.Sale
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.fragment_sales.view.*

/**
 * A simple [Fragment] subclass.
 */
class SalesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_sales, container, false)

        FirebaseFirestore.getInstance().collection("sales").get()
            .addOnSuccessListener {
                // Inflate the layout for this fragment
                view.rvSales.layoutManager=LinearLayoutManager(context)
                var adapter = SalesAdapter(context,it.toObjects())
                view.rvSales.adapter=adapter

            }

        return view
    }

}


