package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.delegates.CategoryViewItemActionDelegate
import com.example.fooddeliveryapp.delegates.RestaurantViewItemActionDelegate
import com.example.fooddeliveryapp.mvp.views.MainView
import mk.padc.share.mvp.presenters.BasePresenter


interface MainPresenter : BasePresenter<MainView> , CategoryViewItemActionDelegate, RestaurantViewItemActionDelegate {
  fun onNavigateDetailScreen()
}