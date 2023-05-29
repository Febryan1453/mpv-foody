package com.febryan.foodmvp.updatedelete

import com.febryan.foodmvp.base.BaseView

interface UpdateDeleteConstract {

    interface View : BaseView {

    }

    interface Presenter {
        fun deleteDataFood(id : String)
        fun updateDataFood(id: String, nameFood: String, priceFood: String, urlFood: String)
    }

}