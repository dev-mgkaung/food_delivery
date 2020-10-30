package com.example.fooddeliveryapp.delegates

import com.example.fooddeliveryapp.datas.vos.FoodItemVO

interface DetailViewItemActionDelegate {
    fun onTapAddToCartAction(data: FoodItemVO)
}