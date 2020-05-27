package com.example.store.user_fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog.Builder
import androidx.recyclerview.widget.GridLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.activities.DealerBrandOffersActivity
import com.example.store.activities.ProductsActivity
import com.example.store.adapters.AdminHomeAdapter
import com.example.store.adapters.AdminHomeAdapter.OnCategoryItemClickListener
import com.example.store.adapters.categoriesAdapter
import com.example.store.model.Category
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlin.collections.ArrayList

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_category, container, false)



        FirebaseFirestore.getInstance().collection("categories").addSnapshotListener { value, e ->
            var categoriesAdapter = categoriesAdapter(context,value!!.toObjects(),object :categoriesAdapter.OnCategoryClicked{
                override fun onCategoryClicked(categoryId:String) {
                    var intent = Intent(activity,DealerBrandOffersActivity::class.java)
                    intent.putExtra(Constants.DBO, Constants.DEALER)
                    intent.putExtra("categoryId",categoryId)
                    startActivity(intent)
                }
            })
            view.rvCategory.adapter=categoriesAdapter
            view.rvCategory.layoutManager=GridLayoutManager(context,3)

        }





        return view
    }

}
