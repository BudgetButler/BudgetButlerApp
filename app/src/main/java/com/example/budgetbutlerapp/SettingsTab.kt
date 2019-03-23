package com.example.budgetbutlerapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner


class SettingsTab : AppCompatActivity() {
    //Currency, Notification, and Country Spinner
    internal lateinit var currencyspin: Spinner
    internal lateinit var notificationspin: Spinner
    internal lateinit var countryspin: Spinner
    internal lateinit var statespin: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_tab2)

        //Sets the variables equal to their corrisponding spinners
        currencyspin = findViewById(R.id.currencyspinner) as Spinner
        notificationspin = findViewById(R.id.notificationspinner) as Spinner
        countryspin = findViewById(R.id.countryspinner) as Spinner
        statespin = findViewById(R.id.statespinner) as Spinner


        // Dropdown options for currency option
        val currency_options = arrayOf("USD", "Euro")
        val currencyadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, currency_options)
        currencyspin.adapter = currencyadp

        // Dropdown options for Notification option
        val notification_options = arrayOf("On", "Off")
        val notificationadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, notification_options)
        notificationspin.adapter = notificationadp

        // Dropdown options for Country option
        val country_options = arrayOf("United States Of America", "Canada", "Mexico")
        val countryadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, country_options)
        countryspin.adapter = countryadp
        // Dropdown options for State option
        val state_options = arrayOf("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
            "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois",
            "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
            "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
            "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon",
            "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands",
            "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming")
        val stateadp = ArrayAdapter(this, android.R.layout.simple_list_item_1, state_options)
        statespin.adapter = stateadp
    }
}




