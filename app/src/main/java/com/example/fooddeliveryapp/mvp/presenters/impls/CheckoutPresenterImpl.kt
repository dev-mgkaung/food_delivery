package com.example.fooddeliveryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.analytics.SCREEN_LOGIN
import com.example.fooddeliveryapp.analytics.SCREEN_REGISTER
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.mvp.presenters.CheckoutPresenter
import com.example.fooddeliveryapp.mvp.views.CheckoutView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class CheckoutPresenterImpl : CheckoutPresenter, AbstractBasePresenter<CheckoutView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onTapCheckout(context: Context,orderList: List<FoodItemVO>) {
        sendEventsToFirebaseAnalytics(context, SCREEN_REGISTER)
        for(order in orderList) {
            foodDeliveryModel.removeFoodItem(order.food_name.toString())
        }
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        sendEventsToFirebaseAnalytics(context, SCREEN_REGISTER)
        foodDeliveryModel.getOrderList(
                onSuccess = {
                    mView.showOrderList(it)
                    calculatePrice()
                },
                onFaiure = {
                    mView?.showError(it)
                })
    }

    override fun onTapIncreaseAddToCartItem(foodItemVO: FoodItemVO) {
        var itemCount = foodItemVO.itemCount.toLong()
        var itemPrice = foodItemVO.food_price.toLong()
        if(itemCount>0)
        {
            itemCount++
        }
        foodItemVO.itemCount= itemCount
        var totalAmount= itemCount * itemPrice
        foodItemVO.totalAmount= totalAmount
        foodDeliveryModel.addOrUpdateFoodItem(foodItemVO)
        calculatePrice()
    }
private  fun calculatePrice()
{
    foodDeliveryModel.getTotalPrice(
            onSuccess = {
                mView?.showCalculationCharge(it)
            },
            onFialure = {
                mView?.showError(it)
            }
    )
}

    override fun onTapDecreaseAddToCartItem(foodItemVO: FoodItemVO) {
        var itemCount = foodItemVO.itemCount.toLong()
        var itemPrice = foodItemVO.food_price.toLong()
        if(itemCount>1)
        {
            itemCount--
        }
        foodItemVO.itemCount= itemCount
        var totalAmount= itemCount * itemPrice
        foodItemVO.totalAmount= totalAmount
        foodDeliveryModel.addOrUpdateFoodItem(foodItemVO)
        calculatePrice()
    }

    override fun onTapRemoveAddToCartItem(foodItemVO: FoodItemVO) {
      foodDeliveryModel.removeFoodItem(foodItemVO?.food_name.toString())
        calculatePrice()
    }


}
