package com.example.store.user_fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.store.Constants
import com.example.store.Constants.Companion.IS_FIRST_OPEN

import com.example.store.R
import com.example.store.activities.MainActivity
import com.example.store.dialogs_Fragments.UpdateFragment
import com.example.store.registration.RegesterationActivity
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
        view.clUsername.setOnClickListener {
            UpdateFragment(object :UpdateFragment.OnUpdate{
                override fun onUpdate(newString: String) {
                    //TODO update name
                }
            }).show(activity!!.supportFragmentManager,"")
        }
        view.clEmail.setOnClickListener {
            UpdateFragment(object :UpdateFragment.OnUpdate{
                override fun onUpdate(newString: String) {
                    //TODO update email
                }
            }).show(activity!!.supportFragmentManager,"")
        }
        view.clMobile.setOnClickListener {
            UpdateFragment(object :UpdateFragment.OnUpdate{
                override fun onUpdate(newString: String) {
                    //TODO update mobile
                }
            }).show(activity!!.supportFragmentManager,"")
        }
        view.clAddress.setOnClickListener {
            UpdateFragment(object :UpdateFragment.OnUpdate{
                override fun onUpdate(newString: String) {
                    //TODO update address
                }
            }).show(activity!!.supportFragmentManager,"")
        }


        view.signOutBtn.setOnClickListener {
            context!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                .edit().putBoolean(IS_FIRST_OPEN,true).apply()
            startActivity(Intent(context,MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

        }


        return view
    }

}
