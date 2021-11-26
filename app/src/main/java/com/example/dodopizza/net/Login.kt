package com.example.dodopizza.net

data class Login(val token:Int){
    companion object Login{
        var userToken: Int? = null
    }
}
