package com.example.dodopizza.net

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRet {
    @POST("user/login")
    fun getUser(@Body hashMap: HashMap<String,String> ): Call<User>

    @GET("quotes")
    fun getQuote(): Call<Quotes>


}