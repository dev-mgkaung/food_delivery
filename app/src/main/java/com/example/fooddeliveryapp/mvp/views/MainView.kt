package com.example.fooddeliveryapp.mvp.views

import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import mk.padc.share.mvp.views.BaseView


interface MainView : BaseView {
    fun changeHomeScreenViewType( viewType : Int)
    fun navigateToDetailScreen()
    fun showErrorMessage(message: String)
    fun showCategories(categoryList: List<CategoryVO>)
    fun showRestaurants(restaurantList: List<RestaurantVO>)
}