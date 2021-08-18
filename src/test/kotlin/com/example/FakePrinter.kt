package com.example

class FakePrinter : Printer{
    var printedString = ""
    override fun print(msg:String){
        printedString = msg

    }
}