package com.example.fooddeliveryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.analytics.SCREEN_PROFILE
import com.example.fooddeliveryapp.analytics.SCREEN_REGISTER
import com.example.fooddeliveryapp.analytics.TAP_LOGIN
import com.example.fooddeliveryapp.analytics.TAP_REGISTER
import com.example.fooddeliveryapp.datas.models.AuthenticationModel
import com.example.fooddeliveryapp.datas.models.AuthenticationModelImpl
import com.example.fooddeliveryapp.mvp.presenters.RegisterPresenter
import com.example.fooddeliveryapp.mvp.views.RegisterView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(context: Context,username: String, email: String, password: String, phone : String) {
        sendEventsToFirebaseAnalytics(context, TAP_REGISTER)
        mAuthenticationModel.register(username, email, password,phone, onSuccess = {
            mView.navigateToToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun navigateToLoginScreen() {
        mView.navigateToToLoginScreen()
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        sendEventsToFirebaseAnalytics(context, SCREEN_REGISTER)
    }
}