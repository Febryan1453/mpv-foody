package com.febryan.foodmvp.updatedelete

import android.util.Log
import com.febryan.foodmvp.api.ApiConfig
import com.febryan.foodmvp.base.BasePresenter
import com.febryan.foodmvp.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDeletePresenter(var updateDeleteView: UpdateDeleteActivity) : BasePresenter<UpdateDeleteConstract.View>, UpdateDeleteConstract.Presenter {

    override fun deleteDataFood(id: String) {
        ApiConfig.service.deleteFood(id).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(call: Call<ResponseGetFood>,response: Response<ResponseGetFood>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        updateDeleteView.showMessage(msg.toString())
                        updateDeleteView.taskEnd()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView.showMessage(t.localizedMessage.toString())
            }
        })
    }

        override fun updateDataFood(id: String, nameFood: String, priceFood: String, urlFood: String) {
        ApiConfig.service.updateFood(id, nameFood, priceFood, urlFood).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(call: Call<ResponseGetFood>,response: Response<ResponseGetFood> ) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        updateDeleteView.showMessage(msg.toString())
                        updateDeleteView.taskEnd()
                        if (msg != null) {
                            Log.d("AYO",msg)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView.showMessage(t.localizedMessage.toString())
            }
        })
    }


}