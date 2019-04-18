package com.example.budgetbutlerapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View

class MonthlySpendingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_spending_page)

        //#165452761
        val navView= findViewById<View>(R.id.nav) as BottomNavigationView

        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settings -> {
                    val intent = Intent(this,SettingsTab::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    /*
    needs to be written in KOTLIN, currently in JAVA
        //function that determines the percentage of savings goal attained
//ticket # 163988151
Public Double percentGoalAttained (Double availMoney, moneyGoal ) {
	Double goalPercentage = availMoney/moneyGoal
	return goalPercentage;
}

//function that determines total monthly spending
//ticket # 163988083
Public void moneySpent (Double [] array){
	Double monthlyExpenses = 0;
	for (int i: array){
		expensesAll+= i;
	}
}

//function that determines monthly savings for user
//ticket # 163988097
Public Double moneySaved (Double monthlyIncome, Double [] expensesArr){
	monthlyExpenses = moneySpent(expensesArr);
	Double monthlySavings = monthlyIncome - monthlyExpenses;
	return monthlySavings;
}
    */
}
