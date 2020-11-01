package com.example.fooddeliveryapp.fragments

import ProfilePresenterImpl
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.UserVO
import com.example.fooddeliveryapp.mvp.presenters.ProfilePresenter
import com.example.fooddeliveryapp.mvp.views.ProfileView
import kotlinx.android.synthetic.main.fragment_account.*
import mk.padc.share.activities.BaseFragment
import mk.padc.share.utils.ImageUtils
import java.io.IOException

class AccountFragment : BaseFragment() ,ProfileView{

    private lateinit var mPresenter: ProfilePresenter

    private  var bitmap : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener()
    {
        img_edit.setOnClickListener{
          mPresenter?.onTapEditProfileImage()
        }
        tv_save.setOnClickListener{
            bitmap?.let { mPresenter.updateUserProfile(it) }
        }
        tv_cancel.setOnClickListener{
            bitmap?.let {
                mPresenter.onTapCancelUserData()
            }
        }
    }
    private fun setUpPresenter() {
        activity?.let{
            mPresenter = getPresenter<ProfilePresenterImpl, ProfileView>()
            context?.let { it1 -> mPresenter.onUiReady(it1,this) }
        }
    }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AccountFragment.PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }
            val filePath = data.data
            try {
                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source = ImageDecoder.createSource(context?.contentResolver!!, filePath)
                        bitmap = ImageDecoder.decodeBitmap(source)
                        account_btngroup.visibility = View.VISIBLE
                        ImageUtils().showImage(img_profile.context,img_profile,null,filePath)
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, filePath)
                        ImageUtils().showImage(img_profile.context,img_profile,null,filePath)
                        account_btngroup.visibility = View.GONE
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), AccountFragment.PICK_IMAGE_REQUEST)
    }

    companion object {
        const val PICK_IMAGE_REQUEST = 1111
        @JvmStatic
        fun newInstance(param1: String, param2: String) = AccountFragment().apply {}
    }

    override fun onTapSaveUserData() {
        account_btngroup.visibility = View.GONE
    }

    override fun onTapCancelUserData() {
        account_btngroup.visibility = View.GONE
    }

    override fun onTapEditProfileImage() {
        openGallery()
    }

    override fun displayUserData(userVO: UserVO) {
        etUserName.text = Editable.Factory.getInstance().newEditable(userVO.name)
        etEmail.text = Editable.Factory.getInstance().newEditable(userVO.email)
        etPassword.text = Editable.Factory.getInstance().newEditable(userVO.password)
        etPhone.text = Editable.Factory.getInstance().newEditable(userVO.phone)
        ImageUtils().showImage(img_profile.context,img_profile,userVO.photoUrl,null)
    }


}