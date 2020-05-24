package com.example.store.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.store.R
import com.example.store.model.Category
import com.example.store.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_edit_product.*

class EditAndAddProductActivity : AppCompatActivity() {
    val TAG = "tag"
    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)
        db = Firebase.firestore

        if (intent.getStringExtra("productRef") != null) {
            val productRef = intent.getStringExtra("productRef")
            FirebaseFirestore.getInstance().document(productRef)
                .addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
                    val product = documentSnapshot!!.toObject<Product>()
                    edProductName.setText(product!!.name)
                    edDescription.setText(product.description)
                    edPrice.setText(product.price.toString())
                    edRate.setText(product.rate.toString())
                    edLong.setText(product.long.toString())
                    edLat.setText(product.lat.toString())
                }
        } else {
            val categoryRef = intent.getStringExtra("categoryRef")
            btnSaveProduct.setOnClickListener {
                pbEditShow.visibility = View.VISIBLE
                var id = "P" + (0..100000).random()
                var name = edProductName.text.toString()
                var description = edDescription.text.toString()
                var price = edPrice.text.toString()
                var rate = edRate.text.toString()
                var long = edLong.text.toString().toDouble()
                var lat = edLat.text.toString().toDouble()

                var product = Product(id, name, description, price, rate, "www.google.com/logo", categoryRef, lat, long)

                FirebaseFirestore.getInstance().collection("$categoryRef/products").document(product.id).set(product)


            }
        }
    }
}
