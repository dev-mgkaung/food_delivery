package com.example.fooddeliveryapp.network.auth

interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(username: String, email: String, password: String, phone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
}