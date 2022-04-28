package com.bugcompany.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {

    // https://jsonplaceholder.typicode.com/posts

    @GET("posts")  // İstek atacağımız restApi urlsi'nin son kısmı yazılır.
    fun getData():Call<List<UserModel>>


}