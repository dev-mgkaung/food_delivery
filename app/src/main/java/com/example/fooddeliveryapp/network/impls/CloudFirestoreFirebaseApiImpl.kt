package com.example.fooddeliveryapp.network.impls

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.util.Log
import com.example.fooddeliveryapp.datas.vos.CategoryVO
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

}
