package com.febryan.foodmvp.model

import com.google.gson.annotations.SerializedName

data class ResponseGetFood(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)