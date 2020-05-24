package com.example.store.admin_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.adapters.TopRatedAdapter
import com.example.store.model.Product
import kotlinx.android.synthetic.main.fragment_top_rated.view.*

/**
 * A simple [Fragment] subclass.
 */
class TopRatedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_top_rated, container, false)
        view.rvTopRateAdmin.layoutManager= LinearLayoutManager(context)
        var products = ArrayList<Product>()
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
//        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
//            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))

        var adapter=TopRatedAdapter(context,products)

        view.rvTopRateAdmin.adapter=adapter

        return view

        }

}
