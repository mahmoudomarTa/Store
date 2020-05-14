package com.example.store.user_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.adapters.CartAdapter
import com.example.store.model.Product
import kotlinx.android.synthetic.main.fragment_cart.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_cart, container, false)
        var c =Calendar.getInstance()
        var day = c.get(Calendar.DAY_OF_MONTH)
        var month = c.get(Calendar.MONTH)
        var year = c.get(Calendar.YEAR)
             var months = arrayOf("January", "February", "March", "April",
            "May", "June", "July", "Augest", "September", "October", "November", "December")

        view.tvDate.text="$day / ${months[month]} / $year"
        var products = ArrayList<Product>()
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        products.add(Product("1","hello","hello world!!",55.71,3.4,40.0,0,ArrayList<String>(),"red","",false,1.0,1.0))
        view.rvItemsInCart.layoutManager=LinearLayoutManager(context)
        var cartAdapter = CartAdapter(context,products,object:CartAdapter.OnCountChange{
            override fun onPlusClicked(id:String, count: Int) {
                Toast.makeText(context, Constants.map.size.toString(),Toast.LENGTH_LONG).show()
                Constants.map.put(id,count)
            }

            override fun onMinusClicked(id:String, count: Int) {
                Toast.makeText(context, Constants.map.size.toString(),Toast.LENGTH_LONG).show()
                Constants.map.put(id,count)
            }

            override fun onItemLongClicked(position: Int) {
                Toast.makeText(context,position.toString(),Toast.LENGTH_LONG).show()
            }
        } )
        view.rvItemsInCart.adapter=cartAdapter


        return view
    }

}
