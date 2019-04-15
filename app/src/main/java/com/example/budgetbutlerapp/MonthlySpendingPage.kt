package com.example.budgetbutlerapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.budgetbutlerapp.R.id.displayItemCost
import com.example.budgetbutlerapp.R.id.displayItemName

class MonthlySpendingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //variable declaration for Spinners
        var rentSpinner: Spinner
        var utilSpinner: Spinner
        var foodSpinner : Spinner
        var purchasesSpinner : Spinner
        var subscriptionsSpinner : Spinner
        var miscSpinner : Spinner
        var addToSpinner : Spinner

        var itemName : TextView
        var itemCost : TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_spending_page)

        //spinners
        rentSpinner = findViewById(R.id.RentSpinner) as Spinner
        utilSpinner = findViewById(R.id.UtilSpinner) as Spinner
        foodSpinner = findViewById(R.id.FoodSpinner) as Spinner
        purchasesSpinner = findViewById(R.id.PurchasesSpinner) as Spinner
        subscriptionsSpinner = findViewById(R.id.SubscriptionsSpinner) as Spinner
        miscSpinner = findViewById(R.id.MiscSpinner) as Spinner
        addToSpinner  = findViewById(R.id.AddToSpinner) as Spinner

        //string arrays for storage
        val rentItem = arrayOf<String>("add Rent")
        val utilItem = arrayOf<String>("add Util")
        val foodItem = arrayOf<String>("add Food")
        val purchaseItem = arrayListOf<String>("add Purchase")
        val subItem = arrayOf<String>("add Subscription")
        val miscItem = arrayOf<String>("add Misc")
        val addToItem = arrayOf<String>("Rent","Util","Food","Purch","Sub","Misc")

        itemName = findViewById(displayItemName)
        itemCost = findViewById(displayItemCost)


        //set default name of
        //rentItem.set(0,"")
        //utilItem.set(0,"add Util")
        //foodItem.set(0,"add Food")
        //purchaseItem.set(0,"add Purchase")
        //subItem.set(0,"add Subscription")
        //miscItem.set(0,"add Misc")
        //addToItem.set(0,"Add Expense")

        rentSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,rentItem)
        utilSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,utilItem)
        foodSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,foodItem)
        purchasesSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,purchaseItem)
        subscriptionsSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,subItem)
        miscSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,miscItem)
        addToSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,addToItem)

        //finish later
        //
        //ticket ##163988114
        //4-7 added output (for testing)

        rentSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                itemName.text = rentItem.get(position)
                itemCost.text = rentItem.get(position)
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
        var monthlyExpenses = moneySpent(expensesArr);
        var monthlySavings = monthlyIncome - monthlyExpenses;
        return monthlySavings;
    }
}