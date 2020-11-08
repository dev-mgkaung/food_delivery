package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.mvp.presenters.LoginPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.LoginPresenterImpl
import com.example.fooddeliveryapp.mvp.views.LoginView
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.installations.FirebaseInstallations
import kotlinx.android.synthetic.main.activity_login.*
import mk.padc.share.activities.BaseActivity

class LoginActivity : BaseActivity() , LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpActionListeners()


        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.d("fbToken", it.token)
        }

//        FirebaseInstallations.getInstance().getToken(/* forceRefresh */ true)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Log.d("Installations", "Installation auth token: " + task.result?.token)
//                } else {
//                    Log.e("Installations", "Unable to get Installation auth token")
//                }
//            }
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(this,ed_email.text.toString(), ed_password.text.toString())
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
        mPresenter.onUiReady(this,this)
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
        this.finish()
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
        this.finish()
    }

}