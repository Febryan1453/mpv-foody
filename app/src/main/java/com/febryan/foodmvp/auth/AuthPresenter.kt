package com.febryan.foodmvp.auth

import android.util.Log
import com.febryan.foodmvp.api.ApiConfig
import com.febryan.foodmvp.base.BasePresenter
import com.febryan.foodmvp.model.auth.ResponseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthPresenter(var authView: AuthActivity) : BasePresenter<AuthConstract.View>, AuthConstract.Presenter{

    override fun loginUser(email: String, password: String) {
        ApiConfig.service.loginUserModel(email, password).enqueue(object : Callback<ResponseAuth>{
            override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        authView.showMessage(msg.toString())
                        msg?.let { Log.d("GAS", it) }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                authView.showMessage(t.localizedMessage.toString())
            }
        })
    }

}