package com.muh.kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://nerbly.com/updatify/apiv1/files/"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById<TextView>(R.id.txtId)
        textView.text = "waiting ..."
        jsonFun()

    }

    private  fun jsonFun(){

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory( GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)


        val call: Call<JsonObject> = retrofitBuilder.fetchFact()
        call.enqueue(object : retrofit2.Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val response = response.body()

                val obj = UpdateDialog()

                obj.showDialog(response.toString(),this@MainActivity)


            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                val textView: TextView = findViewById<TextView>(R.id.txtId)
                textView.text = t.toString()
            }
        })

    }


}