package com.example.budgetbutlerapp

//ticket #165487114
//class for storage of item cost and name input from user.

class Expense constructor(private var _name: String,private var _cost: Double) {

        var name = _name
            get() = field
            set(value) {
              field = value
            }

        var cost = _cost
            get() = field
            set(value) {
                field = value
            }


}

