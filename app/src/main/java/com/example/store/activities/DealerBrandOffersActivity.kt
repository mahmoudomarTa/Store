package com.example.store.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.store.Constants
import com.example.store.R
import com.example.store.user_fragments.BrandFragment
import com.example.store.user_fragments.AddedLaterFragment
import com.example.store.user_fragments.OffersFragment

class DealerBrandOffersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dealer_brand_offers)

        if (intent!=null){
            if(intent.getStringExtra(Constants.DBO).equals(Constants.DEALER)){
                supportFragmentManager.beginTransaction().add(R.id.DealerBrandOffersContainer,AddedLaterFragment()).commit()
            }else if(intent.getStringExtra(Constants.DBO).equals(Constants.OFFERS)){
                supportFragmentManager.beginTransaction().add(R.id.DealerBrandOffersContainer,OffersFragment()).commit()
            }else if(intent.getStringExtra(Constants.DBO).equals(Constants.BRAND)){
                supportFragmentManager.beginTransaction().add(R.id.DealerBrandOffersContainer,BrandFragment()).commit()
            }


        }




    }
}
