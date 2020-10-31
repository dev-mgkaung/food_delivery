package com.example.fooddeliveryapp.delegates

import com.example.fooddeliveryapp.datas.vos.FoodItemVO


interface CheckoutViewItemActionDelegate {
    fun onTapIncreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapDecreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapRemoveAddToCartItem(foodItemVO: FoodItemVO)
}