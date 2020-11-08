package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.fooddeliveryapp.R
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import mk.padc.share.activities.BaseActivity

class MainActivity : BaseActivity()  {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener {
                it?.let{
                    val deepLink = it.link
                    deepLink?.let { deepLink ->
                        Log.d("deepLink", deepLink.toString())
                    }
                }

            }
            .addOnFailureListener {
                Log.d("error", it.localizedMessage)
            }

    }
}