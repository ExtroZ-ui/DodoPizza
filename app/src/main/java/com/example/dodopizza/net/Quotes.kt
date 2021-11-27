package com.example.dodopizza.net


data class Quotes(val success:Boolean, val data:ArrayList<Data_quotes>) {
    class Data_quotes(val int:Int, val title:String, val image:String, val descript:String)
}
