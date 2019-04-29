package com.example.budgetbutlerapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

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
                 R.id.totals -> {
                     val intent = Intent(this,Totals::class.java)
                     startActivity(intent)
                     return@setOnNavigationItemSelectedListener true
                 }

            }
            return@setOnNavigationItemSelectedListener true
        }


    }

}
