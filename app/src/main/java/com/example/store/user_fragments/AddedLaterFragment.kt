package com.example.store.user_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.activities.SecondActivity
import com.example.store.adapters.HomeAdapter
import com.example.store.model.Product
import kotlinx.android.synthetic.main.fragment_added_later.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class AddedLaterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_added_later, container, false)
        if (arguments!=null&&arguments!!.getString("id")!=null){
            //TODO load all products in this category
        }else{


            // consider it as added later fragment and load any thing on it
        }
        view.rvAddedLater.layoutManager=GridLayoutManager(context,2)
        var products = ArrayList<Product>()
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
            Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))

        view.rvAddedLater.adapter= HomeAdapter(context,products,object : HomeAdapter.OnProductClickListener{
            override fun onItemClicked(id: String) {
                var i = Intent(context, SecondActivity::class.java)
                i.putExtra(Constants.ID,id)
                startActivity(i)
            }
        })

        return view
    }

}
