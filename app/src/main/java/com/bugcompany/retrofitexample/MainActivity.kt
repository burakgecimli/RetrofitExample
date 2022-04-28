package com.bugcompany.retrofitexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugcompany.retrofitexample.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userList: ArrayList<UserModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userList = ArrayList<UserModel>()
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = Adapter(applicationContext, userList)

        loadData()

    }


    private fun loadData() {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val retrofitApi = retrofit.create(RetrofitApi::class.java)
        val call = retrofitApi.getData()

        call.enqueue(object : Callback<List<UserModel>> {
            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        userList = response.body() as ArrayList<UserModel>
                        binding.rv.adapter = Adapter(applicationContext, userList)
                    }
                }
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }


}