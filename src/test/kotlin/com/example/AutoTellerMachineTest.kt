package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(true)
        val atmMachine = AutoTellerMachine(fakePrinter,fakeBankingService)

        atmMachine.withdraw(10)
        val expectedAns = "done"
        fakePrinter.printedString shouldBe expectedAns

    }
    "should call banking service when withdrawn called" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(true)
        val atmMachine = AutoTellerMachine(fakePrinter,fakeBankingService)

        atmMachine.withdraw(10)
        val expectedAns = 10
        fakeBankingService.totalAmount shouldBe expectedAns
    }

    "should throw exception if banking service throws an exception" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(false)
        val atmMachine = AutoTellerMachine(fakePrinter,fakeBankingService)

        atmMachine.withdraw(10)
        val expectedAns = "Error"
        fakePrinter.printedString shouldBe expectedAns

    }
})