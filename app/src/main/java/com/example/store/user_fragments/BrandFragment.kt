package com.example.store.user_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.example.store.R
import com.example.store.adapters.BrandAdapter
import com.example.store.dialogs_Fragments.FilterFragment
import com.example.store.model.Brand
import kotlinx.android.synthetic.main.fragment_brand.view.*

/**
 * A simple [Fragment] subclass.
 */
class BrandFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_brand, container, false)
        view.rvBrands.layoutManager=GridLayoutManager(context!!,2)
        var brands=ArrayList<Brand>()
        brands.add(Brand("hello","",3.1))
        brands.add(Brand("hello","",3.2))
        brands.add(Brand("hello","",1.1))
        brands.add(Brand("hello","",3.8))
        brands.add(Brand("hello","",4.9))
        brands.add(Brand("hello","",2.1))
        brands.add(Brand("hello","",4.1))
        brands.add(Brand("hello","",1.9))
        brands.add(Brand("hello","",2.5))
        brands.add(Brand("hello","",4.5))
        brands.add(Brand("hello","",5.0))
        brands.add(Brand("hello","",4.2))

        var brandAdapter = BrandAdapter(context!!,brands)
        view.rvBrands.adapter=brandAdapter


        view.clSearch.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.DealerBrandOffersContainer,SearchAboutBrandFragment()).addToBackStack(null).commit()
        }
        view.clFilter.setOnClickListener {
            FilterFragment(object :FilterFragment.OnFilter{
                override fun onDataFilterd(type: String) {
                    //TODO : if type equal R.string.filterFromLowToHigh .... else .....

                }
            }).show(activity!!.supportFragmentManager!!,null)
        }

        return  view
    }

}
