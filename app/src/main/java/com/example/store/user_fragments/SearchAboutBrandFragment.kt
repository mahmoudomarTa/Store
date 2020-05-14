package com.example.store.user_fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager

import com.example.store.R
import com.example.store.adapters.BrandAdapter
import com.example.store.model.Brand
import kotlinx.android.synthetic.main.fragment_search_about_brand.view.*

/**
 * A simple [Fragment] subclass.
 */
class SearchAboutBrandFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_search_about_brand, container, false)

        var brandsNames = ArrayList<String>()
        brandsNames.add("hello")
        brandsNames.add("hello")
        brandsNames.add("hello")
        brandsNames.add("hello")
        brandsNames.add("hello")

        //TODO : hide the progress bar and make the auto comp... is clickable

        view.actAboutBrand.setAdapter(ArrayAdapter(context!!,android.R.layout.simple_list_item_1,brandsNames))
        view.actAboutBrand.setOnItemClickListener { parent, view, position, id ->
            view.ppBrands.visibility=View.VISIBLE
            loadData()


        }


        view.rvBrandsInSearch.layoutManager=GridLayoutManager(context,2)

        return view
    }
        fun loadData(){
            view!!.rvBrandsInSearch.layoutManager=GridLayoutManager(context,2)
            var brands=ArrayList<Brand>()
            var adapter = BrandAdapter(context!!,brands)
            view!!.rvBrandsInSearch.adapter=adapter
        }
}
