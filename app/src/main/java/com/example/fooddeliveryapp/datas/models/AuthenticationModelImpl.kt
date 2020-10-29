package com.example.fooddeliveryapp.datas.models

import com.example.fooddeliveryapp.network.auth.AuthManager
import com.example.fooddeliveryapp.network.auth.FirebaseAuthManager

object AuthenticationModelImpl : AuthenticationModel {

    override var mAuthManager: AuthManager = FirebaseAuthManager

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password, onSuccess, onFailure)
    }

    override fun register(
        username: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(username, email, password,phone, onSuccess, onFailure)
    }

}