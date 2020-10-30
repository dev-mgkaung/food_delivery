package com.example.fooddeliveryapp.network

import android.graphics.Bitmap
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.datas.vos.UserVO

interface FirebaseApi {
    fun uploadPhotoToFirebaseStorage(image : Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)
    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit, onFialure: (String) -> Unit)
    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFialure: (String) -> Unit)
}