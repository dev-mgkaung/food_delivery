package com.example.fooddeliveryapp.datas.models

import android.graphics.Bitmap
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

    override fun uploadProfileImage(image: Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.uploadUserProfile(image ,onSuccess,onFailure)

    }

}