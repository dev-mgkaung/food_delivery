package com.example.fooddeliveryapp.datas.models

import com.example.fooddeliveryapp.network.FirebaseApi
import com.example.fooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getHomeScreenTypeStatusFromRemoteConfig() : Int
}