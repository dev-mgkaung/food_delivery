package com.example.fooddeliveryapp.datas.models

import android.graphics.Bitmap
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.network.FirebaseApi
import com.example.fooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getHomeScreenTypeStatusFromRemoteConfig() : Int

    fun uploadPhotoToFirebaseStorage( image : Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getFoodItems(documentId: String, onSuccess: (List<FoodItemVO>,RestaurantVO) -> Unit, onFaiure: (String) -> Unit)

}