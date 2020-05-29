package com.example.store.user_fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants
import com.example.store.Constants.Companion.IS_FIRST_OPEN

import com.example.store.R
import com.example.store.activities.EditAndAddProductActivity
import com.example.store.activities.MainActivity
import com.example.store.adapters.AdminProductsAdapter
import com.example.store.adapters.AdminProductsAdapter.OnProductClickListener
import com.example.store.dialogs_Fragments.UpdateFragment
import com.example.store.model.Product
import com.example.store.registration.RegesterationActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.activity_products.pbAdminProducts
import kotlinx.android.synthetic.main.activity_products.rv_admin_products
import kotlinx.android.synthetic.main.fragment_profile.tvEmail
import kotlinx.android.synthetic.main.fragment_profile.tvMobile
import kotlinx.android.synthetic.main.fragment_profile.tvUseName
import kotlinx.android.synthetic.main.fragment_profile.userId
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
//        view.clUsername.setOnClickListener {
//            UpdateFragment(object :UpdateFragment.OnUpdate{
//                override fun onUpdate(newString: String) {
//                    //TODO update name
//                }
//            }).show(activity!!.supportFragmentManager,"")
//        }
//        view.clEmail.setOnClickListener {
//            UpdateFragment(object :UpdateFragment.OnUpdate{
//                override fun onUpdate(newString: String) {
//                    //TODO update email
//                }
//            }).show(activity!!.supportFragmentManager,"")
//        }
//        view.clMobile.setOnClickListener {
//            UpdateFragment(object :UpdateFragment.OnUpdate{
//                override fun onUpdate(newString: String) {
//                    //TODO update mobile
//                }
//            }).show(activity!!.supportFragmentManager,"")
//        }
//        view.clAddress.setOnClickListener {
//            UpdateFragment(object :UpdateFragment.OnUpdate{
//                override fun onUpdate(newString: String) {
//                    //TODO update address
//                }
//            }).show(activity!!.supportFragmentManager,"")
//        }

        view.signOutBtn.setOnClickListener {
            context!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                .edit().putBoolean(IS_FIRST_OPEN, true).apply()
            startActivity(Intent(context, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            FirebaseAuth.getInstance().signOut()
        }


        FirebaseFirestore.getInstance().document("users/${FirebaseAuth.getInstance().currentUser!!.uid}")
            .addSnapshotListener { value, e ->

                val user = value!!.toObject<com.example.store.model.User>()
                tvUseName.text = user!!.email.substringBefore("@")
                tvEmail.text = user.email
                tvMobile.text = user.mobile
                userId.text = user.id

                //TODO ADD MAP CODE HERE
//                user.lat
//                user.long


            }




        return view
    }
}
