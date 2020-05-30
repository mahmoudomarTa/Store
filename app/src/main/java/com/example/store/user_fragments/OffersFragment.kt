package com.example.store.user_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.adapters.OffersAdapter
import com.example.store.model.Product
import kotlinx.android.synthetic.main.fragment_offers.view.*

/**
 * A simple [Fragment] subclass.
 */
class OffersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_offers, container, false)
        view.rvOffers.layoutManager=LinearLayoutManager(context)

        var products = ArrayList<Product>()


        var offersAdapter=OffersAdapter(context,products,object:OffersAdapter.OnOfferClickListener{
            override fun onOfferClicked(id: String) {

            }
        })
        view.rvOffers.adapter=offersAdapter

        return view
    }

}
