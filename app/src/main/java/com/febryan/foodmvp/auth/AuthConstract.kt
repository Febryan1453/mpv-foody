package com.febryan.foodmvp.auth

import com.febryan.foodmvp.base.BaseView

interface AuthConstract {

    interface View : BaseView {

    }

    interface Presenter {
        fun loginUser(email: String, password: String)
    }
}