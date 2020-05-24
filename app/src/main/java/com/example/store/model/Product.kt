package com.example.store.model

data class Product(var id:String? = "" , var name:String? = "",var description:String? = "",
               var price: Double? = 0.0,var rate:Double?= 0.0,var discount:Double?= 0.0,var time:Long?= 0,
               var photo: String?= "",var color:String?= "",var category:String?= "",
               var isLikedFromCurrantUser:Boolean?= false,
               var lat:Double?= 0.0,var long:Double? = 0.0)