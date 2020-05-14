package com.example.store.user_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.store.Constants
import com.example.store.Constants.Companion.IS_FIRST_OPEN

import com.example.store.R
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



        view.signOutBtn.setOnClickListener {
            context!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                .edit().putBoolean(IS_FIRST_OPEN,true).apply()
        }
        return view
    }

}
