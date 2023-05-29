package com.febryan.foodmvp.main

import com.febryan.foodmvp.base.BaseView
import com.febryan.foodmvp.model.DataItem

interface MainConstruct {

    interface view : BaseView {
        fun showDataFood(dataFood: List<DataItem?>?)
    }

    interface Presenter{
        fun getAllFood()
        fun tambahDataMakanan(namaMakanan: String, hargaMakanan: String, gambarMakanan: String)
    }

}