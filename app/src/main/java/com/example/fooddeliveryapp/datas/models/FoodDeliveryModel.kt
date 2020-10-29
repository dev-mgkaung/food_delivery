package com.example.fooddeliveryapp.datas.models

import android.graphics.Bitmap
import com.example.fooddeliveryapp.network.FirebaseApi
import com.example.fooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getHomeScreenTypeStatusFromRemoteConfig() : Int

    fun uploadProfileImage( image : Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)

}