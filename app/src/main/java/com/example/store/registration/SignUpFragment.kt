package com.example.store.registration

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.IntentCompat
import androidx.fragment.app.Fragment
import com.example.store.Constants
import com.example.store.R
import com.example.store.activities.AdminHomeActivity
import com.example.store.activities.UserHomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()


        view.btnSignUp.setOnClickListener {
            val email = view.edEmailSignUp.text.toString()
            val mobile = view.edMobileSignUp.text.toString()
            val password = view.edPasswordSignUp.text.toString()

            if (email.equals("admin") && password.equals("admin")) {
                var intent = Intent(activity!!, AdminHomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit()
                    .putBoolean(Constants.IS_FIRST_OPEN, false).apply()
                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE).edit()
                    .putBoolean(Constants.IS_USER, false).apply()
                return@setOnClickListener
            }

            if (edEmailSignUp.text.length < 6) {
                Constants.printToast(context, getString(R.string.emailShouldBe6))
                return@setOnClickListener
            }
            if (!edEmailSignUp.text.endsWith("@gmail.com")) {
                Constants.printToast(context, getString(R.string.emailEndsWithGmailCom))
                return@setOnClickListener
            }
            if (edMobileSignUp.text.length < 8) {
                Constants.printToast(context, getString(R.string.mobileShouldBe))
                return@setOnClickListener
            }
            if (edPasswordSignUp.text.length < 6) {
                Constants.printToast(context, getString(R.string.passwordShouldbe6))
                return@setOnClickListener
            }

            ppSignUp.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity!!) { task ->
                    if (task.isSuccessful) {
                        var user = mapOf(
                            "id" to auth.currentUser!!.uid,
                            "email" to email,
                            "mobile" to mobile,
                            "password" to password
                        )
                        firestore.collection("users").document(auth.currentUser!!.uid).set(user)
                            .addOnSuccessListener {
                                ppSignUp.visibility = View.GONE
                                var intent = Intent(activity!!, UserHomeActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                                startActivity(intent)
                                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                                    .edit()
                                    .putBoolean(Constants.IS_FIRST_OPEN, false).apply()
                                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                                    .edit()
                                    .putBoolean(Constants.IS_USER, true).apply()
                                activity!!.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
                                    .edit()
                                    .putString(Constants.ID, auth.currentUser!!.uid).apply()

                            }.addOnFailureListener {
                            ppSignUp.visibility = View.GONE
                            Toast.makeText(context, "Authentication failed.", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        ppSignUp.visibility = View.GONE
                        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_LONG).show()
                    }
                }

        }
        view.tvAllreadyHaveAccount.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.RegistrationContainer, SigninFragment())
                .commit()
        }

        view.tv_signin.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.RegistrationContainer, SigninFragment())
                .commit()
        }

        return view
    }
}
