package com.example.fooddeliveryapp.mvp.presenters

import android.content.Context
import com.example.fooddeliveryapp.mvp.views.LoginView
import mk.padc.share.mvp.presenters.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(context: Context, email: String, password: String)
    fun onTapRegister()
}