package com.example.fooddeliveryapp.mvp.presenters.impls

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.analytics.SCREEN_LOGIN
import com.example.fooddeliveryapp.analytics.TAP_LOGIN
import com.example.fooddeliveryapp.datas.models.AuthenticationModel
import com.example.fooddeliveryapp.datas.models.AuthenticationModelImpl
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.mvp.presenters.LoginPresenter
import com.example.fooddeliveryapp.mvp.views.LoginView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl

    private  val mFoodDeliveryModel : FoodDeliveryModel =FoodDeliveryModelImpl

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        sendEventsToFirebaseAnalytics(context, SCREEN_LOGIN)
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(context: Context,email: String, password: String) {

        if(email.isEmpty() || password.isEmpty()){
            mView.showError("Please enter all the fields")
        } else {

            sendEventsToFirebaseAnalytics(context, TAP_LOGIN)
            mAuthenticatioModel.login(email, password, onSuccess = {
                mView.navigateToHomeScreen()
            }, onFailure = {
                mView.showError(it)
            })
        }
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}