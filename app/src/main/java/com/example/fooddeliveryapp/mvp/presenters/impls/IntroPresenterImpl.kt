package com.example.fooddeliveryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.analytics.SCREEN_HOME
import com.example.fooddeliveryapp.analytics.SCREEN_INTRO
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.views.IntroView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class IntroPresenterImpl : IntroPresenter, AbstractBasePresenter<IntroView>() {

    override fun onTapGettingStarted() {
       mView?.navigateToLoginScreen()
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        sendEventsToFirebaseAnalytics(context, SCREEN_INTRO)
    }
}

