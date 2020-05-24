package com.example.store.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.store.Constants
import com.example.store.R
import com.example.store.adapters.BrandAdapter
import com.example.store.adapters.ProductAdapter
import com.example.store.adapters.categoriesAdapter
import com.example.store.adapters.categoriesAdapter.OnCategoryClicked
import com.example.store.user_fragments.BrandFragment
import com.example.store.user_fragments.AddedLaterFragment
import com.example.store.user_fragments.OffersFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.activity_dealer_brand_offers.rv
import kotlinx.android.synthetic.main.fragment_category.view.rvCategory

class DealerBrandOffersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dealer_brand_offers)

        if (intent.getStringExtra("categoryId") != null) {
                val categoryId = intent.getStringExtra("categoryId")
            FirebaseFirestore.getInstance().collection("categories/${categoryId}/products").addSnapshotListener { value, e ->
                var categoriesAdapter = ProductAdapter(this@DealerBrandOffersActivity, value!!.toObjects())
                rv.adapter = categoriesAdapter
                rv.layoutManager = GridLayoutManager(this@DealerBrandOffersActivity, 3)

            }
        } else {

        }
    }
}
