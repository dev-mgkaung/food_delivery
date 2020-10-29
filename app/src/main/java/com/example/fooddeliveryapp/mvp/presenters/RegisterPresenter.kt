package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.mvp.views.RegisterView
import mk.padc.share.mvp.presenters.BasePresenter


interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(username: String, email: String, password: String,phone : String)
    fun navigateToLoginScreen()
}