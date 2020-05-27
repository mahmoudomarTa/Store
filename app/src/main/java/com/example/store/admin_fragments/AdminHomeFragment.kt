package com.example.store.admin_fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.set
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.activities.ProductsActivity
import com.example.store.adapters.AdminHomeAdapter
import com.example.store.dialogs_Fragments.UpdateFragment
import com.example.store.model.Category
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.fragment_admin_home.*
import kotlinx.android.synthetic.main.fragment_admin_home.view.*
import java.util.Random

/**
 * A simple [Fragment] subclass.
 */
class AdminHomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_admin_home, container, false)
        var rv_admin_home = view.findViewById<RecyclerView>(R.id.rv_admin_home)
        var btnAddCategory = view.findViewById<FloatingActionButton>(R.id.btnAddCategory)
        rv_admin_home.layoutManager = LinearLayoutManager(context)


        // TODO : load data and make peogress bar visibility gone

        FirebaseFirestore.getInstance().collection("categories").addSnapshotListener { value, e ->
            val adapter = AdminHomeAdapter(
                context!!,
                value!!.toObjects(),
                object : AdminHomeAdapter.OnCategoryItemClickListener {
                    override fun onItemClicked(category: Category) {
                        // open another screen that contains all this category products
                        var intent = Intent(activity, ProductsActivity::class.java)
                        intent.putExtra("id", category.id)
                        intent.putExtra("categoryName", category.name)
                        startActivity(intent)
                    }

                    override fun onItemLongClicked(category: Category) {
                        val alert = AlertDialog.Builder(context!!)

                        val edittext = EditText(context!!)
                        edittext.setText(category.name)
                        edittext.maxLines = 1

                        val layout = FrameLayout(context!!)

                        //set padding in parent layout
                        layout.setPaddingRelative(45, 15, 45, 0)

                        alert.setTitle("Add New Category")

                        layout.addView(edittext)

                        alert.setView(layout)

                        alert.setPositiveButton("Add") { _, _ ->
                            category.name = edittext.text.toString()
                            FirebaseFirestore.getInstance().collection("categories").document(category.id)
                                .set(category)

                        }
                        alert.setNegativeButton(
                            "Cancel",
                            DialogInterface.OnClickListener { dialog, which ->
                                dialog.dismiss()

                            })

                        alert.show()
                    }

                    override fun onDeleteImgClicked(category: Category) {
                    }
                })
            rv_admin_home.adapter = adapter
            view.pbAdminHome.visibility=View.GONE

        }




        btnAddCategory.setOnClickListener {
            val alert = AlertDialog.Builder(context!!)

            val edittext = EditText(context!!)
            edittext.hint = "Enter Name"
            edittext.maxLines = 1

            val layout = FrameLayout(context!!)

            //set padding in parent layout
            layout.setPaddingRelative(45, 15, 45, 0)

            alert.setTitle("Add New Category")

            layout.addView(edittext)

            alert.setView(layout)

            alert.setPositiveButton("Add") { _, _ ->
                val categoryId = (0..1000).random().toString()
                FirebaseFirestore.getInstance().collection("categories").document(categoryId)
                    .set(Category(categoryId, edittext.text.toString()))

            }
            alert.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()

                })

            alert.show()
        }


        return view
    }
}
