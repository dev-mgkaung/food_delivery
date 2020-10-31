package com.example.fooddeliveryapp.mvp.views

import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import mk.padc.share.mvp.views.BaseView

interface DetailView : BaseView {
    fun showRestaurantData(restaurantVO: RestaurantVO)
    fun showPopularChoicesFoodItem(popularFoodList: List<FoodItemVO>)
    fun showFoodItemList(foodList: List<FoodItemVO>)
    fun showViewCartCount(cartCount : Long)
}