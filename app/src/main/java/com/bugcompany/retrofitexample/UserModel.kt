package com.bugcompany.retrofitexample

import com.google.gson.annotations.SerializedName

data class UserModel(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerializedName("body") val subTitle: String
) {

}