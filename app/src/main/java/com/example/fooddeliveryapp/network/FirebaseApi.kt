package com.example.fooddeliveryapp.network

import android.graphics.Bitmap
import com.example.fooddeliveryapp.datas.vos.UserVO

interface FirebaseApi {
    fun uploadUserProfile(image : Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)
}