package com.example.store.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.Constants
import com.example.store.R
import com.example.store.adapters.ColorsAdapter
import com.example.store.adapters.HomeAdapter.OnProductClickListener
import com.example.store.adapters.ProductAdapter
import com.example.store.model.Product
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.android.synthetic.main.activity_dealer_brand_offers.rv
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private lateinit var mMap: GoogleMap
    private var MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestThePermission()



        if (intent != null) {
            val productRef = intent.getStringExtra("productRef")
            loadProduct(productRef)
            //Toast.makeText(this,id,Toast.LENGTH_LONG).show()

            var linerLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            rvColors.layoutManager = linerLayoutManager
            var colors = arrayOf(
                Color.CYAN, Color.BLACK,
                Color.DKGRAY, Color.GREEN,
                Color.LTGRAY, Color.MAGENTA,
                Color.YELLOW, Color.RED,
                Color.GRAY
            );
            var colorsAdapter = ColorsAdapter(this, colors, object : ColorsAdapter.OnColorSelected {
                override fun onColorSelect(color: Int) {
                }
            })
            rvColors.adapter = colorsAdapter

            //view.imgAboutItem
        }
    }

    private fun loadProduct(documentRef: String) {
        FirebaseFirestore.getInstance().document(documentRef)
            .addSnapshotListener() { value, e ->
                val product = value!!.toObject<Product>()
                tvItemName.text = product!!.name
                //TODO: Fill the rest of the UI Data.
                // loadMap(product.lat, product.long)
            }
    }

    private fun requestThePermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_REQUEST_READ_CONTACTS
            )
        } else {
            loadMap()
        }
    }

    private fun loadMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            mMap = it
            val product = LatLng(31.506731, 34.461367)
            val markerOptions = MarkerOptions()
            markerOptions.position(product)
            markerOptions.title("mahmoud tabaza home")
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.delivery))
            mMap.addMarker(markerOptions)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(product, 10f))

            var locationClient = LocationServices.getFusedLocationProviderClient(this)
            locationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    var long = location.longitude
                    var lat = location.latitude
                    mMap.addMarker(
                        MarkerOptions().position(LatLng(lat, long)).title(getString(R.string.yourLocation))
                    )
                    mMap.addPolyline(PolylineOptions().add(LatLng(lat, long), product).color(Color.RED).visible(true))
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
            }

        }
    }
}
