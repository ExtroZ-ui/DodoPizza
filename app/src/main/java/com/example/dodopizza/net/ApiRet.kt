package com.example.dodopizza.net

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRet {
    @POST("auth/login")
    fun login(@Body hashMap: HashMap<String,String> ): Call<Login>


}