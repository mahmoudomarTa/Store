package com.example.store.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.store.Constants

import com.example.store.R
import com.example.store.activities.AdminHomeActivity
import com.example.store.activities.UserHomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_regesteration.*
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signin.view.*

/**
 * A simple [Fragment] subclass.
 */
class SigninFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_signin, container, false)

        auth = FirebaseAuth.getInstance()
        firestore= FirebaseFirestore.getInstance()


        view.btnSignIn.setOnClickListener {

            var email = edEmailSignIn.text.toString()
            var password = edPasswordSignIn.text.toString()

            if (email.equals("admin")&&password.equals("admin")){
                startActivity(Intent(context, AdminHomeActivity::class.java))
                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putBoolean(Constants.IS_FIRST_OPEN,false).apply()
                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putBoolean(Constants.IS_USER,false).apply()
                return@setOnClickListener
            }
            if(edEmailSignIn.text.length<6){
                Constants.printToast(context, getString(R.string.emailShouldBe6))
                return@setOnClickListener
            }
            if (!edEmailSignIn.text.endsWith("@gmail.com")){
                Constants.printToast(context, getString(R.string.emailEndsWithGmailCom))
                return@setOnClickListener
            }
            if (edPasswordSignIn.text.length<6){
                Constants.printToast(context, getString(R.string.passwordShouldbe6))
                return@setOnClickListener
            }
            ppSignIn.visibility=View.VISIBLE
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity!!) { task ->
                    if (task.isSuccessful) {
                        ppSignIn.visibility=View.GONE
                        var intent = Intent(context,UserHomeActivity::class.java)
                        startActivity(intent)
                        activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putBoolean(Constants.IS_FIRST_OPEN,false).apply()
                        activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putBoolean(Constants.IS_USER,true).apply()
                        activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putString(Constants.ID,auth.currentUser!!.uid).apply()

                    } else {
                        ppSignIn.visibility=View.GONE
                        Toast.makeText(context, "sign in failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        view.tvIdontHaveAccount.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.RegistrationContainer,SignUpFragment()).commit()
        }

        return view
    }

}
