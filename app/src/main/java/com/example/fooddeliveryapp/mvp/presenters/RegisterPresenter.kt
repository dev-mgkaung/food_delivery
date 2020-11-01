package com.example.fooddeliveryapp.mvp.presenters

import android.content.Context
import com.example.fooddeliveryapp.mvp.views.RegisterView
import mk.padc.share.mvp.presenters.BasePresenter


interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(context: Context, username: String, email: String, password: String, phone : String)
    fun navigateToLoginScreen()
}