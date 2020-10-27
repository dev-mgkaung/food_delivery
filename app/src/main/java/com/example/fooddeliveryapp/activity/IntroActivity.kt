package com.example.fooddeliveryapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddeliveryapp.R
import kotlinx.android.synthetic.main.activity_intro_screeen.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_intro_screeen)

        btn_get_started.setOnClickListener{

        startActivity(LoginActivity.newIntent(this))

        this.finish()
        }
    }

}