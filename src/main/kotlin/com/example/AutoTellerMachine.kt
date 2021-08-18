package com.example

class AutoTellerMachine(val printer: Printer, val BankingService: BankingService) {

    fun withdraw(amount: Int) {
        //WRITE CODE HERE.
        val msg = "done"
        try {
            BankingService.withdraw(amount)
            printer.print(msg)

        }catch (exception:Exception){
            printer.print("Error")
        }




    }





}