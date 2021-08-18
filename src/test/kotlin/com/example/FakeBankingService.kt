package com.example

class FakeBankingService(val isTransitionDone: Boolean) : BankingService {

    var totalAmount = 0
    override fun withdraw(amount: Int) {
        if (!isTransitionDone) {throw Exception("Failed To Withdraw Amount")}
        else {totalAmount=amount}

    }
}