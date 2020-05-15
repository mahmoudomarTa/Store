package com.example.store.admin_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.activities.ProductsActivity
import com.example.store.adapters.AdminHomeAdapter
import com.example.store.dialogs_Fragments.UpdateFragment
import com.example.store.model.Category
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 */
class AdminHomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_admin_home, container, false)
        var rv_admin_home = view.findViewById<RecyclerView>(R.id.rv_admin_home)
        var btnAddCategory = view.findViewById<FloatingActionButton>(R.id.btnAddCategory)
        rv_admin_home.layoutManager= LinearLayoutManager(context)
        btnAddCategory.setOnClickListener {


        }
        // TODO : load data and make peogress bar visibility gone
        var data =ArrayList<Category>()
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))
        data.add(Category("name","name",""))

        val adapter= AdminHomeAdapter(context!!,data,object :AdminHomeAdapter.OnCategoryItemClickListener{
            override fun onItemClicked(category: Category) {
                // open another screen that contains all this category products
                var intent = Intent(activity,ProductsActivity::class.java)
                intent.putExtra("id",category.id)
                intent.putExtra("categoryName",category.name)
                startActivity(intent)
            }
            override fun onItemLongClicked(category: Category) {
                UpdateFragment(object : UpdateFragment.OnUpdate{
                    override fun onUpdate(newString: String) {
                        Toast.makeText(context,"$newString",Toast.LENGTH_LONG).show()
                    }
                }).show(activity!!.supportFragmentManager,null)
            }
            override fun onDeleteImgClicked(category: Category) {
                Toast.makeText(context,"delete",Toast.LENGTH_LONG).show()
            }
        })
        rv_admin_home.adapter=adapter

        btnAddCategory.setOnClickListener {

        }


        return view
    }

}
