package com.example.store.model

data class Product(
    var id: String = "", var name: String = "", var description: String = "",
    var price: String = "", var rate: String = "",
    var img: String = "", var category: String = "",
    var lat: Double = 0.0, var long: Double = 0.0
)