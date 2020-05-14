package com.example.store

import android.content.Context
import android.widget.Toast
import java.util.*
import kotlin.collections.HashMap

class Constants {
    companion object{
        val OFFERS = "OFFERS"
        val BRAND = "BRAND"
        val DEALER = "DEALER"
        val DBO = "DBO"
        val ID="id"
        var SHARED_PREF_NAME = "SHARED_PREF_NAME"
        var IS_FIRST_OPEN="IS_FIRST_OPEN"
        var IS_USER = "IS_USER"
        fun printToast(context: Context , text:String){
            Toast.makeText(context,text, Toast.LENGTH_SHORT).show()
        }
        fun getTimeInMILS():Long{
            var c = Calendar.getInstance()
            return c.timeInMillis
        }
        var map = HashMap<String,Int>()
    }

}