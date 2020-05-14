package com.example.store.user_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.store.R
import com.example.store.adapters.categoriesAdapter
import com.example.store.model.Category
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlin.collections.ArrayList

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_category, container, false)

        var categories = ArrayList<Category>()

        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))
        categories.add(Category("hello","hello",""))


        //TODO get all categories from firebase




        var categoriesAdapter = categoriesAdapter(context,categories)
        view.rvCategory.adapter=categoriesAdapter
        view.rvCategory.layoutManager=GridLayoutManager(context,3)


        return view
    }

}
