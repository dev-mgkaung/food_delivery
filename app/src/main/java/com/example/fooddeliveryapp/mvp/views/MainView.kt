package com.example.fooddeliveryapp.mvp.views

import mk.padc.share.mvp.views.BaseView


interface MainView : BaseView {
    fun showUserName(name : String)
}