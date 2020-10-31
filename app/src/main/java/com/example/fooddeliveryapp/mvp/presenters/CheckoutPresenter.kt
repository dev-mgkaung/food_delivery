package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import com.example.fooddeliveryapp.mvp.views.CheckoutView
import mk.padc.share.mvp.presenters.BasePresenter

interface CheckoutPresenter : BasePresenter<CheckoutView>,CheckoutViewItemActionDelegate {
fun onTapCheckout(orderList: List<FoodItemVO>)
}