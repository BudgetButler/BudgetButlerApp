package com.example.budgetbutlerapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MonthlySpendingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_spending_page)
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
