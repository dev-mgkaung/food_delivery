package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.mvp.presenters.MainPresenter
import com.example.fooddeliveryapp.mvp.views.MainView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onNavigateDetailScreen(documentId : String) {
      mView?.navigateToDetailScreen(documentId)
    }

    override fun onUiReady(owner: LifecycleOwner) {
         mView?.changeHomeScreenViewType(foodDeliveryModel.getHomeScreenTypeStatusFromRemoteConfig())

         foodDeliveryModel.getCategories(
                onSuccess = {
                   mView.showCategories(it)
                },
                onFaiure = {
             //       mView.showErrorMessage(it)
                })

        foodDeliveryModel.getRestaurants(
                onSuccess = {
                    mView.showRestaurants(it)
                },
                onFaiure = {
                    //       mView.showErrorMessage(it)
                })

        foodDeliveryModel.getPopularChoiceList(
            onSuccess = {
                mView.showPopularChoicesFoodItems(it)
            },
            onFaiure = {
                //       mView.showErrorMessage(it)
            })

    }

    override fun onTap() {

    }

    override fun onTapRestaurentListItem(documentId: String) {
        mView.navigateToDetailScreen(documentId)
    }

    override fun onTapPopularChoiceListItem() {
    }

}