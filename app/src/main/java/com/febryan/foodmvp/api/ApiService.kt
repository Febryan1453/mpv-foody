package com.febryan.foodmvp.api

import com.febryan.foodmvp.model.ResponseGetFood
import com.febryan.foodmvp.model.auth.ResponseAuth
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("getMakanan")
    fun getFood() : Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("insertMakanan")
    fun insertFood(@Field("name") namaFood : String,
                   @Field("price") priceFood : String,
                   @Field("gambar") urlFood : String) : Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("updateMakanan")
    fun updateFood(@Field("id") id : String,
                   @Field("name") namaFood : String,
                   @Field("price") priceFood : String,
                   @Field("gambar") urlFood : String) : Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("deleteMakanan")
    fun deleteFood(@Field("id") id : String): Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("login")
    fun loginUserModel(@Field("email") email : String,
                       @Field("password") password : String) : Call<ResponseAuth>
}