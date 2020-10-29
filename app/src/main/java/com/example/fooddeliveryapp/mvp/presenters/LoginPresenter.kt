package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.mvp.views.LoginView
import mk.padc.share.mvp.presenters.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}