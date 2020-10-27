package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddeliveryapp.R
import kotlinx.android.synthetic.main.activity_intro_screeen.*
import kotlinx.android.synthetic.main.activity_intro_screeen.btn_get_started
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signup.setOnClickListener{

            startActivity(RegisterActivity.newIntent(this))

            this.finish()
        }
    }
}