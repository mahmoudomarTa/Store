package com.example.store.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog.Builder
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants
import com.example.store.R
import com.example.store.adapters.AdminHomeAdapter
import com.example.store.adapters.AdminHomeAdapter.OnCategoryItemClickListener
import com.example.store.adapters.AdminProductsAdapter
import com.example.store.model.Category
import com.example.store.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        if (intent.getStringExtra("id") != null) {
            var categoryId = intent.getStringExtra("id")
            FirebaseFirestore.getInstance().collection("categories/$categoryId/products")
                .addSnapshotListener { value, e ->
                    rv_admin_products.layoutManager = LinearLayoutManager(this)

                    var adapter =
                        AdminProductsAdapter(
                            this,
                            value!!.toObjects(),
                            object : AdminProductsAdapter.OnProductClickListener {
                                override fun onProductClicked(product: Product) {
                                }

                                override fun onEditClicked(product: Product) {
                                    var intent = Intent(applicationContext, EditAndAddProductActivity::class.java)
                                    intent.putExtra("id", product.id)
                                    intent.putExtra("productRef", "categories/$categoryId/products/" + product.id)
                                    startActivity(intent)
                                }

                                override fun onDeleteClicked(product: Product) {
                                    FirebaseFirestore.getInstance().collection("categories/$categoryId/products/").document(product.id).delete()

                                }
                            })

                    rv_admin_products.adapter = adapter
                    pbAdminProducts.visibility= View.GONE
                }
            btnAddproduct.setOnClickListener {
                val i = Intent(applicationContext, EditAndAddProductActivity::class.java)
                i.putExtra("categoryRef", "categories/$categoryId")

                startActivity(i)
            }
        }
    }
}
