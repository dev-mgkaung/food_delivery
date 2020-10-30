package com.example.fooddeliveryapp.datas.models

import android.graphics.Bitmap
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.network.FirebaseApi
import com.example.fooddeliveryapp.network.impls.CloudFirestoreFirebaseApiImpl
import com.example.fooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager


object FoodDeliveryModelImpl : FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override  var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDeaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getHomeScreenTypeStatusFromRemoteConfig(): Int {
        return  mFirebaseRemoteConfigManager.getHomeScreenViewTypeStatus()
    }

    override fun uploadPhotoToFirebaseStorage(image: Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.uploadPhotoToFirebaseStorage(image ,onSuccess,onFailure)
    }


    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getCategories(onSuccess, onFaiure)
    }

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getRestaurants(onSuccess, onFaiure)
    }



    override fun getFoodItems(
        documentId: String,
        onSuccess: (List<FoodItemVO>,RestaurantVO) -> Unit,
        onFaiure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodItems(documentId,onSuccess, onFaiure)
    }

}