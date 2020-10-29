package com.example.fooddeliveryapp.mvp.views

import android.graphics.Bitmap
import com.example.fooddeliveryapp.datas.vos.UserVO
import mk.padc.share.mvp.views.BaseView

interface ProfileView : BaseView {
    fun onTapSaveUserData()
    fun onTapCancelUserData()
    fun onTapEditProfileImage()
    fun displayUserData(userVO: UserVO)
}