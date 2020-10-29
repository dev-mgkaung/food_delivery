package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.mvp.views.IntroView
import mk.padc.share.mvp.presenters.BasePresenter

interface IntroPresenter : BasePresenter<IntroView> {
    fun onTapGettingStarted()
}