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

        var category = intent.getStringExtra("categoryName")
        if (intent.getStringExtra("id") != null) {
            val productRef = intent.getStringExtra("productRef")
            FirebaseFirestore.getInstance().document(productRef)
                .addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
                    val product = documentSnapshot!!.toObject<Product>()
                    edProductName.setText(product!!.name)
                }
        } else {
            btnSaveProduct.setOnClickListener {
                pbEditShow.visibility = View.VISIBLE
                var name = edProductName.text.toString()
                var description = edDescription.text.toString()
                var price = edPrice.text.toString().toDouble()
                var rate = edRate.text.toString().toDouble()
                var discount = edDiscount.text.toString().toDouble()
                var long = edLong.text.toString().toDouble()
                var lat = edLat.text.toString().toDouble()

                var product = Product(
                    System.currentTimeMillis().toString(),
                    name,
                    description,
                    price,
                    rate,
                    discount,
                    System.currentTimeMillis(),
                    "",
                    "",
                    category!!,
                    false,
                    lat,
                    long
                )
                FirebaseFirestore.getInstance().collection("categories").document(product.category!!)
                    .collection("products")
                    .add(product)
                    .addOnSuccessListener { documentReference ->
                        pbEditShow.visibility = View.GONE
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        pbEditShow.visibility = View.GONE
                        Log.w(TAG, "Error adding document", e)
                    }

            }
        }
    }
}
