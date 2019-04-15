package com.example.budgetbutlerapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import android.widget.CompoundButton
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent






class SettingsTab : AppCompatActivity() {
    //Currency, Notification, and Country Spinner
    internal lateinit var currencyspin: Spinner
    internal lateinit var notificationspin: Spinner
    internal lateinit var countryspin: Spinner
    internal lateinit var statespin: Spinner
    internal lateinit var customtax: EditText
    internal lateinit var usestatetax: Switch
    internal lateinit var currencytext: TextView
    internal lateinit var taxtext: TextView
    internal lateinit var backbuttons : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_tab2)

        //Sets the variables equal to their corrisponding spinners
        currencyspin = findViewById(R.id.currencyspinner) as Spinner
        notificationspin = findViewById(R.id.notificationspinner) as Spinner
        countryspin = findViewById(R.id.countryspinner) as Spinner
        statespin = findViewById(R.id.statespinner) as Spinner
        customtax = findViewById(R.id.customTax) as EditText
        usestatetax = findViewById(R.id.taxoverride) as Switch
        currencytext = findViewById(R.id.textView2) as TextView
        taxtext = findViewById(R.id.taxpercenttext) as TextView
        backbuttons = findViewById(R.id.backbutton) as Button

        //Checks if the user wants to use their states tax, if not, they can set their own
        usestatetax.setOnCheckedChangeListener { buttonView, isChecked ->
            if(usestatetax.isChecked){
                customtax.isEnabled = false;
                taxtext.setVisibility(View.INVISIBLE);
            } else {
                customtax.isEnabled = true;
                taxtext.setVisibility(View.VISIBLE);
            }
        }
        //This sends the user back to MainActivity.kt
        backbuttons.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
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




