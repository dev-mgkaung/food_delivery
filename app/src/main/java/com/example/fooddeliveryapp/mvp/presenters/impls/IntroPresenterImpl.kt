package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.views.IntroView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class IntroPresenterImpl : IntroPresenter, AbstractBasePresenter<IntroView>() {
    override fun onTapGettingStarted() {
       mView?.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {}
}

