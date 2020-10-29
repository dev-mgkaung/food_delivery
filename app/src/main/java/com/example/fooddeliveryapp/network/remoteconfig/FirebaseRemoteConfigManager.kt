package com.example.fooddeliveryapp.network.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings


object FirebaseRemoteConfigManager
{
    private val remoteConfig = Firebase.remoteConfig

    init{
        val configSettings  = remoteConfigSettings {
            minimumFetchIntervalInSeconds =0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun setUpRemoteConfigWithDeaultValues()
    {
        val defaultValues : Map<String,Any> = hashMapOf(
            "homeScreenViewType" to 0
        )
        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfigs()
    {
        remoteConfig.fetch()
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Log.e("Firebase" ,"Firebase Remote Config fetch Success")
                    remoteConfig.activate().addOnCompleteListener{
                        Log.d("Firebase", "Firebase Remote Config actived")
                    }
                }else{
                    Log.d("Firebase", "Firebase Remote Config fetch failed")
                }
            }
    }


    fun getHomeScreenViewTypeStatus() : Int{
        return remoteConfig.getValue("homeScreenViewType").asString().toInt()
    }
}