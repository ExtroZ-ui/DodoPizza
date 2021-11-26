package com.example.dodopizza.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.locks.ReentrantReadWriteLock

class MyRetrofit {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://cinema.areas.su/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}