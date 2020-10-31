package com.example.fooddeliveryapp.network.impls

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.util.Log
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.datas.vos.UserVO
import com.example.fooddeliveryapp.network.FirebaseApi
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.util.*

object CloudFirestoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference


    override fun uploadPhotoToFirebaseStorage(image: Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            onFailure("Update Profile Failed")
        }.addOnSuccessListener { taskSnapshot ->
            Log.d(TAG, "User profile updated.")
        }


        val urlTask = uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener { task ->
            val imageUrl = task.result?.toString()
            imageUrl?.let { onSuccess(it) }
        }

    }

    override fun getCategories(onSuccess: (groceries: List<CategoryVO>) -> Unit, onFialure: (String) -> Unit) {

        db.collection("categories")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFialure(it.message ?: "Please check connection")
                    } ?: run{

                        val categoryList: MutableList<CategoryVO> = arrayListOf()

                        val result = value?.documents ?: arrayListOf()

                        for (document in result) {
                            val hashmap = document.data
                            hashmap?.put("id", document.id.toString())
                            val Data = Gson().toJson(hashmap)
                            val docsData = Gson().fromJson<CategoryVO>(Data, CategoryVO::class.java)
                            categoryList.add(docsData)
                        }

                        onSuccess(categoryList)
                    }
                }

    }

    override fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFialure: (String) -> Unit) {
        db.collection("restaurants")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFialure(it.message ?: "Please check connection")
                    } ?: run{

                        val restaurantList: MutableList<RestaurantVO> = arrayListOf()

                        val result = value?.documents ?: arrayListOf()

                        for (document in result) {
                            val hashmap = document.data
                            hashmap?.put("id", document.id.toString())
                            val Data = Gson().toJson(hashmap)
                            val docsData = Gson().fromJson<RestaurantVO>(Data, RestaurantVO::class.java)
                            restaurantList.add(docsData)
                        }

                        onSuccess(restaurantList)
                    }
                }
    }


    override fun getFoodItems(
        documentId: String,
        onSuccess: (foodList: List<FoodItemVO>, restaurantVO : RestaurantVO) -> Unit,
        onFialure: (String) -> Unit
    ) {
        var restaurant: RestaurantVO  = RestaurantVO()
        db.collection("restaurants").document(documentId)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFialure(it.message ?: "Please check connection")
                } ?: run{

                        val data = value?.data
                        val restaurantVO = RestaurantVO()
                        restaurantVO.name = data?.get("name") as String
                        restaurantVO.description = data["description"] as String?
                        restaurantVO.image_url = data["image_url"] as String?
                        restaurantVO.rating = data["rating"] as String?

                    restaurant = restaurantVO
                }
            }

        db.collection("restaurants/${documentId}/fooditems")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFialure(it.message ?: "Please check connection")
                } ?: run{

                    val foodList: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<FoodItemVO>(Data, FoodItemVO::class.java)
                        foodList.add(docsData)
                    }
                    onSuccess(foodList ,restaurant)
                }
            }
    }

    override fun getPopularChoiceList(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        db.collectionGroup("fooditems").whereEqualTo("popular","1")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFialure(it.message ?: "Please check connection")
                } ?: run{

                    val popularList: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id.toString())
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<FoodItemVO>(Data, FoodItemVO::class.java)
                        popularList.add(docsData)
                    }

                    onSuccess(popularList)
                }
            }
    }

    override fun getOrderList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit) {
        db.collection("orders")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFialure(it.message ?: "Please check connection")
                    } ?: run{

                        val orderList: MutableList<FoodItemVO> = arrayListOf()

                        val result = value?.documents ?: arrayListOf()

                        for (document in result) {
                            val hashmap = document.data
                            hashmap?.put("id", document.id.toString())
                            val Data = Gson().toJson(hashmap)
                            val docsData = Gson().fromJson<FoodItemVO>(Data, FoodItemVO::class.java)
                            orderList.add(docsData)
                        }

                        onSuccess(orderList)
                    }
                }
    }

    override fun addOrUpdateFoodItem(foodItemVO: FoodItemVO) {

        db.collection("orders")
                .document(foodItemVO?.food_name.toString())
                .set(foodItemVO)
                .addOnSuccessListener { Log.d("Success", "Successfully added grocery") }
                .addOnFailureListener { Log.d("Failure", "Failed to add grocery") }

    }

    override fun deleteFoodItem(id: String) {

        db.collection("orders")
                .document(id)
                .delete()
                .addOnSuccessListener { Log.d("Success", "Successfully deleted grocery") }
                .addOnFailureListener { Log.d("Failure", "Failed to delete grocery") }

    }

    override fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit) {
        db.collection("orders")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFialure(it.message ?: "Please check connection")
                    } ?: run{
                        val result = value?.documents ?: arrayListOf()
                        onSuccess(result.size.toLong())
                    }
                }
    }

    override fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit) {
        db.collection("orders")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFialure(it.message ?: "Please check connection")
                    } ?: run{
                        val result = value?.documents ?: arrayListOf()
                        val orderList: MutableList<FoodItemVO> = arrayListOf()

                        for (document in result) {
                            val hashmap = document.data
                            hashmap?.put("id", document.id.toString())
                            val Data = Gson().toJson(hashmap)
                            val docsData = Gson().fromJson<FoodItemVO>(Data, FoodItemVO::class.java)
                            orderList.add(docsData)
                        }
                        var totalAmount : Long =0
                        for(entity in orderList)
                        {
                            totalAmount += entity.totalAmount
                        }
                        onSuccess(totalAmount)
                    }
                }
    }


}
