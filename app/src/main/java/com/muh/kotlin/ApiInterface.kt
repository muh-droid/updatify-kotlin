package com.muh.kotlin

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("testkotlin_46864215.json")
    fun fetchFact() : Call<JsonObject>

}