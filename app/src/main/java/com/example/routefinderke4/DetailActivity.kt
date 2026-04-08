package com.example.routefinderke4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val route = intent.getParcelableExtra<Route>("EXTRA_ROUTE")

        route?.let {
            supportActionBar?.title = "Route ${it.number}"
            findViewById<TextView>(R.id.textDetailRoute).text = "${it.origin} to ${it.destination}"
            findViewById<TextView>(R.id.textDetailFare).text = "Estimated Fare: ${it.fare}"
            findViewById<TextView>(R.id.textDetailStops).text = it.stops.joinToString("\n• ", prefix = "• ")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
