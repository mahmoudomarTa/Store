package com.example.store.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.store.Constants.Companion.IS_FIRST_OPEN
import com.example.store.Constants.Companion.IS_USER
import com.example.store.Constants.Companion.SHARED_PREF_NAME
import com.example.store.R
import com.example.store.registration.RegesterationActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var IS_FIRST_OPEN =getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).getBoolean(IS_FIRST_OPEN,true)
        var IS_USER =getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).getBoolean(IS_USER,true)
        Handler().postDelayed(Runnable {
            if (IS_FIRST_OPEN){
                startActivity(Intent(this,
                    RegesterationActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }else{
                if(IS_USER){
                    startActivity(Intent(this,UserHomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                }else{
                    startActivity(Intent(this,AdminHomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                }
            }
        },1500)



    }
}
