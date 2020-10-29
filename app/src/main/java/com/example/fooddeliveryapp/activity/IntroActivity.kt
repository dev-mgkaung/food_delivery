package com.example.fooddeliveryapp.activity

import android.os.Bundle
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.IntroPresenterImpl
import com.example.fooddeliveryapp.mvp.views.IntroView
import kotlinx.android.synthetic.main.activity_intro_screeen.*
import mk.padc.share.activities.BaseActivity

class IntroActivity : BaseActivity() , IntroView {

    private lateinit var mPresenter: IntroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screeen)
        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btn_get_started.setOnClickListener{
            mPresenter.onTapGettingStarted()
            this.finish()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<IntroPresenterImpl, IntroView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

}