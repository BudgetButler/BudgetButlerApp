package com.example.budgetbutlerapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.TextView

class Totals : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_totals)

        var displayRent: TextView
        var displayMisc: TextView
        var displayFood: TextView
        var displaySubscriptions: TextView
        var displayUtilities: TextView
        var displayTotal: TextView

        displayRent = findViewById(R.id.displayTotalRent) as TextView
        displayMisc = findViewById(R.id.displayTotalMisc) as TextView
        displayFood = findViewById(R.id.displayTotalFood) as TextView
        displaySubscriptions = findViewById(R.id.displayTotalSubscriptions) as TextView
        displayUtilities = findViewById(R.id.displayTotalUtilities) as TextView
        displayTotal = findViewById(R.id.displayTotal)

        val navView= findViewById<View>(R.id.nav) as BottomNavigationView

        //Navigation listener
        // #165452761
        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                //Listener for spend icon
                R.id.spend -> {
                    val intent = Intent(this,MonthlySpendingPage::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                //Listener for settings icon
                R.id.settings -> {
                    val intent = Intent(this,SettingsTab::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }

            }
            return@setOnNavigationItemSelectedListener true
        }

        //displays the values from the shared preference file from the MonthlySpendingPage
        val PREF_NAME = "UserTransactions"
        val sharedPreference: SharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        displayRent.text = sharedPreference.getString("ttRent", "")
        displayMisc.text = sharedPreference.getString("ttMisc", "")
        displayUtilities.text = sharedPreference.getString("ttUtilities", "")
        displayFood.text = sharedPreference.getString("ttFood", "")
        displaySubscriptions.text = sharedPreference.getString("ttSubscriptions", "")
        displayTotal.text = sharedPreference.getString("ttTotal", "")



    }

}