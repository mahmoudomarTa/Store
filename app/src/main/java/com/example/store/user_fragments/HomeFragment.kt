package com.example.store.user_fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.store.Constants

import com.example.store.R
import com.example.store.activities.DealerBrandOffersActivity
import com.example.store.activities.SecondActivity
import com.example.store.adapters.HomeAdapter
import com.example.store.adapters.SliderAdapter
import com.example.store.model.Category
import com.example.store.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_product.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        var ids:IntArray = intArrayOf(
            R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f4, R.drawable.f5, R.drawable.f6,
            R.drawable.f7
        )


        var ids2:IntArray = intArrayOf(
            R.drawable.f1, R.drawable.f2, R.drawable.f3,
            R.drawable.f4, R.drawable.f5, R.drawable.f6,
            R.drawable.f7
        )

        view.imageSlider.sliderAdapter=SliderAdapter(ids)
        view.imageSlider.startAutoCycle();
        view.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        view.imageSlider.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        view.imageSlider.setScrollTimeInSec(3);

        view.imageSlider2.sliderAdapter=SliderAdapter(ids2)
        view.imageSlider2.startAutoCycle();
        view.imageSlider2.setIndicatorAnimation(IndicatorAnimations.WORM);
        view.imageSlider2.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        view.imageSlider2.setScrollTimeInSec(4);




        FirebaseFirestore.getInstance().collection("categories")
            .addSnapshotListener { value, e ->
                val x = value!!.toObjects<Category>()
                x.forEach {
                    FirebaseFirestore.getInstance().collection("categories/${it.id}/products")
                        .addSnapshotListener { values, e ->

                            val productList = values!!.toObjects<Product>()
                            var names = ArrayList<String>()
                            productList.forEach{
                                names.add(it.name)
                            }

                            view.edSearchAtv.setAdapter(ArrayAdapter(context!!,android.R.layout.simple_list_item_1,names))


                            view.edSearchAtv.setOnItemClickListener { parent, view, position, id ->
                                var i = Intent(context,SecondActivity::class.java)
                                i.putExtra("productRef","${productList[position].category}/products/${productList[position].id}")
                                startActivity(i)
                            }


                            view.rvHome.adapter=HomeAdapter(context,productList,object :HomeAdapter.OnProductClickListener{
                                override fun onItemClicked(id: String,position:Int) {
                                    Toast.makeText(context!!,"$id",Toast.LENGTH_LONG).show()
                                    Log.d("ttt","$id")
                                    var i = Intent(context,SecondActivity::class.java)
                                    i.putExtra("productRef","${productList[position].category}/products/${productList[position].id}")
                                    startActivity(i)
                                }
                            })
                            view.rvHome.layoutManager=GridLayoutManager(context,2)


                        }
                }
            }



        view.clDealer.setOnClickListener {
            val i = Intent(context,DealerBrandOffersActivity::class.java)
            i.putExtra(Constants.DBO,Constants.DEALER)
            startActivity(i)
        }
        view.clBrand.setOnClickListener {
            val i = Intent(context,DealerBrandOffersActivity::class.java)
            i.putExtra(Constants.DBO,Constants.BRAND)
            startActivity(i)
        }
        view.clOffers .setOnClickListener {
            val i = Intent(context,DealerBrandOffersActivity::class.java)
            i.putExtra(Constants.DBO,Constants.OFFERS)
            startActivity(i)
        }



        return  view
    }

}
