package com.example.fooddeliveryapp.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class FoodDeliveryFirebaseMessageService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("token", token)
        super.onNewToken(token)
    }
}