package com.example.budgetbutlerapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.*
import android.content.Intent
import android.content.SharedPreferences
import com.example.budgetbutlerapp.R.id.displayItemCost
import com.example.budgetbutlerapp.R.id.displayItemName
import com.google.android.gms.common.util.Strings
import kotlinx.android.synthetic.main.activity_monthly_spending_page.*
import org.w3c.dom.Text


class MonthlySpendingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var addTransation: ImageButton
        var displayCost: TextView
        var displayType: TextView
        var userName : TextView
        var userAmount : TextView
        //variable declaration for Spinners
        var transactionSpinner: Spinner
        var transactionType: Spinner
        var itemName : TextView
        var itemCost : TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_spending_page)
        val navView= findViewById<View>(R.id.nav) as BottomNavigationView

        //Navigation listener
        // #165452761
        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                //Listener for spend icon
                R.id.totals -> {
                    val intent = Intent(this,Totals::class.java)
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


        //Initializing shared prefernces for data storage
        val PREF_NAME = "UserTransactions"
        val sharedPreference: SharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreference.edit()

        //spinners of storage (name and cost of expenses)
        transactionSpinner = findViewById(R.id.Expenses) as Spinner
        transactionType = findViewById(R.id.AddToSpinner) as Spinner
        displayCost = findViewById(R.id.displayCost) as TextView
        displayType = findViewById(R.id.displayType) as TextView
        itemName = findViewById(R.id.entryItemName)as TextView
        itemCost = findViewById(R.id.entryItemCost) as TextView

        //string arrays for storage
        val transactionArray = arrayListOf<Transactions>()
        val transactionNames = arrayListOf<String>()
        val tranTypeArray = arrayOf<String>("Rent", "Food", "Utilities", "Subscriptions", "Misc")

        //Adapters for the spinners
        val tranTypeAdp = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tranTypeArray)
        transactionType.adapter = tranTypeAdp


        val tranNameAdp = ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,transactionNames)
        transactionSpinner.adapter = tranNameAdp



        //ticket ##163988114
        //4-7 added output (for testing)
        //Creates transactions object and adds it to an array, transaction information
        //taken from user
        addButton.setOnClickListener {
            val name: String = itemName.text.toString()
            val cost: String = itemCost.text.toString()
            val pcost = cost.toDoubleOrNull()
            if (pcost != null) {
                val type: String = transactionType.selectedItem.toString()
                transactionArray.add(Transactions(name, pcost, type))
                transactionNames.add(name)
                val tranNameAdp = ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,transactionNames)
                transactionSpinner.adapter = tranNameAdp

            }
            else{
                val toast = Toast.makeText(applicationContext, "Invalid Information, Try again", Toast.LENGTH_LONG)
                toast.show()
            }

            //Total calculations for each type
            var tRent: Double = 0.0
            var tMisc: Double = 0.0
            var tUtilities: Double = 0.0
            var tFood: Double = 0.0
            var tSubscriptions: Double = 0.0

                var total: Double = 0.0

            for(i in transactionArray){
                if(i.type == "Rent")
                    total += i.cost
            }
            tRent = total
            total = 0.0
            for(i in transactionArray){
                if(i.type == "Food")
                    total += i.cost
            }
            tFood = total
            total = 0.0
            for(i in transactionArray){
                if(i.type == "Utilities")
                    total += i.cost
            }
            tUtilities = total
            total = 0.0
            for(i in transactionArray){
                if(i.type == "Subscriptions")
                    total += i.cost
            }
            tSubscriptions = total
            total = 0.0
            for(i in transactionArray){
                if(i.type == "Misc")
                    total += i.cost
            }
            tMisc = total

            total = tRent+tMisc+tSubscriptions+tFood+tUtilities

            //Saves the values to memory
            editor.putString("ttRent", tRent.toString())
            editor.putString("ttMisc", tMisc.toString())
            editor.putString("ttFood", tFood.toString())
            editor.putString("ttUtilities", tUtilities.toString())
            editor.putString("ttSubscriptions", tSubscriptions.toString())
            editor.putString("ttTotal", total.toString())
            editor.commit()
        }

        //This changes the text boxes to the selected expense
        transactionSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                displayType.text = transactionArray[position].type
                displayCost.text = transactionArray[position].cost.toString()
            }
        }
    }



    //function that determines the percentage of savings goal attained
//ticket # 163988151
    fun percentGoalAttained(availMoney: Double, moneyGoal: Double): Double {
        var goalPercentage = availMoney / moneyGoal
        return goalPercentage
    }

    //function that determines total monthly spending
//ticket # 163988083
    fun moneySpent(arr: Array<Double>): Double {
        var monthlyExpenses = 0.0;
        for (i in arr) {
            monthlyExpenses += i;
        }
        return monthlyExpenses
    }


    //function that determines monthly savings for user
//ticket # 163988097
    fun moneySaved(monthlyIncome: Double, expensesArr: Array<Double>): Double {
        return 0.0
    }
}