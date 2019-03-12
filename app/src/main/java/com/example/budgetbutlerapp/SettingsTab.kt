package com.example.budgetbutlerapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner


class SettingsTab : AppCompatActivity() {
    //Currency, Notification, and Country Spinner
    internal lateinit var cusp: Spinner
    internal lateinit var nsp: Spinner
    internal lateinit var cosp: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_tab2)

        //Sets the variables equal to their corrisponding spinners
        cusp = findViewById(R.id.cuspinner) as Spinner
        nsp = findViewById(R.id.nspinner) as Spinner
        cosp = findViewById(R.id.cospinner) as Spinner

        // Dropdown options for currency option
        val currency_options = arrayOf("USD", "Euro")
        val currencyadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, currency_options)
        cusp.adapter = currencyadp

        // Dropdown options for Notification option
        val notification_options = arrayOf("On", "Off")
        val notificationadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, notification_options)
        nsp.adapter = notificationadp

        // Dropdown options for Country option
        val country_options = arrayOf("United States Of America", "Canada", "Mexico")
        val countryadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, country_options)
        cosp.adapter = countryadp
    }
}




