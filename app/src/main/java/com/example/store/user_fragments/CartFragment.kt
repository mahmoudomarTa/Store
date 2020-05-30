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
import com.example.store.model.Sale
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
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
        var salesList = ArrayList<Sale>()
        view.rvItemsInCart.layoutManager=LinearLayoutManager(context)

        FirebaseFirestore.getInstance().collection("sales").addSnapshotListener() { values , e ->

            for (sale in values!!.toObjects<Sale>()) {
                if (sale.userId == FirebaseAuth.getInstance().currentUser!!.uid) {
                    salesList.add(sale)
                }
            }

                var cartAdapter = CartAdapter(context,salesList,object:CartAdapter.OnCountChange{
                    override fun onPlusClicked(id:String, count: Int) {
//                        Toast.makeText(context, Constants.map.size.toString(),Toast.LENGTH_LONG).show()
//                        Constants.map.put(id,count)
                    }

                    override fun onMinusClicked(id:String, count: Int) {
                      //  Toast.makeText(context, Constants.map.size.toString(),Toast.LENGTH_LONG).show()
                      //  Constants.map.put(id,count)
                    }

                    override fun onItemLongClicked(position: Int) {
//                        Toast.makeText(context,position.toString(),Toast.LENGTH_LONG).show()
                    }
                } )
                view.rvItemsInCart.adapter=cartAdapter

            }




        return view
    }

}
