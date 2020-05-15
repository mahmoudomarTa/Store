package com.example.store.model

data class Product(var id:String , var name:String ,var description:String ,
               var price: Double ,var rate:Double,var discount:Double,var time:Long,
               var photo: String,var color:String,var category:String,
               var isLikedFromCurrantUser:Boolean,
               var lat:Double,var long:Double)