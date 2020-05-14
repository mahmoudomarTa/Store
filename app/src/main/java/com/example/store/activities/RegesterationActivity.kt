package com.example.store.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.store.Constants.Companion.printToast
import com.example.store.R
import kotlinx.android.synthetic.main.activity_regesteration.*

class RegesterationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regesteration)
        btnRegester.setOnClickListener {

            var email = edEmail.text.toString()
            var password = edPassword.text.toString()

            if (email.equals("admin")&&password.equals("admin")){
                startActivity(Intent(this,AdminHomeActivity::class.java))
                return@setOnClickListener
            }
            if(edEmail.text.length<6){
                printToast(this,getString(R.string.emailShouldBe6))
                return@setOnClickListener
            }
            if (!edEmail.text.endsWith("@gmail.com")){
                printToast(this,getString(R.string.emailEndsWithGmailCom))
                return@setOnClickListener
            }
            if (edPassword.text.length<6){
                printToast(this,getString(R.string.passwordShouldbe6))
                return@setOnClickListener
            }

            //TODO register the user in firebase


        }

    }
}
