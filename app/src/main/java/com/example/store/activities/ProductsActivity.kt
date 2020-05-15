package com.example.store.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants
import com.example.store.R
import com.example.store.adapters.AdminProductsAdapter
import com.example.store.model.Product
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        if (intent.getStringExtra("id")!=null){


            var id = intent.getStringExtra("id")
            // Todo load all products in this category
            rv_admin_products.layoutManager=LinearLayoutManager(this)
            var products = ArrayList<Product>()
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))
            products.add(Product("1","hello","hello world!!",55.71,3.4,50.0,
                Constants.getTimeInMILS(),"ArrayList<String>()","red","",false,1.0,1.0))

            var adapter = AdminProductsAdapter(this,products,object : AdminProductsAdapter.OnProductClickListener{
                override fun onProductClicked(product: Product) {

                }

                override fun onEditClicked(product: Product) {
                    var intent = Intent(applicationContext,EditAndAddProductActivity::class.java)
                    intent.putExtra("id",product.id)
                    startActivity(intent)
                }

                override fun onDeleteClicked(product: Product) {
                    // TODO("Not yet implemented")
                }
            })

            rv_admin_products.adapter=adapter


        }

        btnAddproduct.setOnClickListener {
            val i = Intent(applicationContext,EditAndAddProductActivity::class.java)
            i.putExtra("categoryName",intent.getStringExtra("categoryName"))
            startActivity(i)
        }




    }
}
