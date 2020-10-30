package com.example.fooddeliveryapp.datas.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class FoodItemVO(
    var food_name: String?= "",
    var food_description: String? = "",
    var food_price: String? = "",
    var food_rating: String? = "",
    var food_image: String? = "",
    var popular: String? = ""
)