package com.example.fooddeliveryapp.mvp.views

import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import mk.padc.share.mvp.views.BaseView

interface CheckoutView : BaseView {
    fun showOrderList(orderList: List<FoodItemVO>)
    fun showCalculationCharge(totalAmount: Long)

}