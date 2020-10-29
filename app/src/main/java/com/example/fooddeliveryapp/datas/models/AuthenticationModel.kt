package com.example.fooddeliveryapp.datas.models

import com.example.fooddeliveryapp.datas.vos.UserVO
import com.example.fooddeliveryapp.network.auth.AuthManager


interface AuthenticationModel {

    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        username: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
   fun userData(
           onSuccess: (userVO : UserVO) -> Unit,
           onFailure: (String) -> Unit
   )

    fun updateProfile(
            photoUrl : String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )

}