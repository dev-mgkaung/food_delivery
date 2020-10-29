package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.datas.models.AuthenticationModel
import com.example.fooddeliveryapp.datas.models.AuthenticationModelImpl
import com.example.fooddeliveryapp.mvp.presenters.RegisterPresenter
import com.example.fooddeliveryapp.mvp.views.RegisterView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(username: String, email: String, password: String, phone : String) {
        mAuthenticationModel.register(username, email, password,phone, onSuccess = {
            mView.navigateToToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun navigateToLoginScreen() {
        mView.navigateToToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {}
}