package com.example.fooddeliveryapp.mvp.presenters

import android.graphics.Bitmap
import com.example.fooddeliveryapp.mvp.views.ProfileView
import mk.padc.share.mvp.presenters.BasePresenter

interface ProfilePresenter : BasePresenter<ProfileView> {
    fun updateUserProfile(bitmap: Bitmap)
    fun onTapCancelUserData()
    fun onTapEditProfileImage()
}