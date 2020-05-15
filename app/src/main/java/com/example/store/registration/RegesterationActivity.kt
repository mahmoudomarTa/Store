package com.example.store.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.store.Constants.Companion.printToast
import com.example.store.R
import com.example.store.activities.AdminHomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_regesteration.*

class RegesterationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regesteration)
        supportFragmentManager.beginTransaction().replace(R.id.RegistrationContainer,SignUpFragment()).commit()

    }
}
