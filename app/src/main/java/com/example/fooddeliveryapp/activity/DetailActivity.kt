package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.fooddeliveryapp.R
import mk.padc.share.activities.BaseActivity

class DetailActivity : BaseActivity()  {
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatil)
    }
}