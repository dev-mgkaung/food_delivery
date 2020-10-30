package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.mvp.presenters.DetailPresenter
import com.example.fooddeliveryapp.mvp.views.DetailView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {}

    override fun onfetchReastaurantData(owner: LifecycleOwner, documentId: String) {

        foodDeliveryModel.getFoodItems(
            documentId,
            onSuccess = {
                dataList, restaurant ->
                mView.showPopularChoicesFoodItem(
                    dataList.filter{
                        data -> data.popular == "1"
                    }
                )
                mView.showRestaurantData(restaurant)
                mView.showFoodItemList(dataList)
            },
            onFaiure = {
                       mView?.showError(it)
            })
    }

    override fun onTapDelegateAction() {}

    override fun onTapPopularChoiceDelegateAction() {}
}
