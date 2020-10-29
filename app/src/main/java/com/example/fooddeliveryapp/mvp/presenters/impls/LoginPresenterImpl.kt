package com.example.fooddeliveryapp.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
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

    override fun onUiReady(owner: LifecycleOwner) {
        Log.e("Firebase","login ui ready")
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(email: String, password: String) {
        mAuthenticatioModel.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}