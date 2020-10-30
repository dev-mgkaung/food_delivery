package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.mvp.presenters.CheckoutPresenter
import com.example.fooddeliveryapp.mvp.views.CheckoutView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class CheckoutPresenterImpl : CheckoutPresenter, AbstractBasePresenter<CheckoutView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        foodDeliveryModel.getOrderList(
                onSuccess = {
                    mView.showOrderList(it)
                    mView.showCalculationCharge()
                },
                onFaiure = {
                    mView?.showError(it)
                })
    }

    override fun onTap() {

    }


}
