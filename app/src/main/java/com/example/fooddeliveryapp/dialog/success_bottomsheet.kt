package com.example.fooddeliveryapp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fooddeliveryapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.checkout_success_layout.*

class BottomSheetFragment() : BottomSheetDialogFragment() {

    private var fragmentView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.checkout_success_layout, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btn_order_track.setOnClickListener {
            Toast.makeText(context, "Order Track Clicked", Toast.LENGTH_SHORT).show()
            this.dialog?.dismiss()
        }
        btn_order_something.setOnClickListener {
            Toast.makeText(context, "Order Something Else Clicked", Toast.LENGTH_SHORT).show()
            this.dialog?.dismiss()
        }

    }
}

//
//For BottomSheetDialog add below method in MainActivity.java .
//
//private fun showBottomSheetDialog() {
//    val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
//    val dialog = BottomSheetDialog(this)
//    dialog.setContentView(view)
//    view.textViewFacebook.setOnClickListener {
//        Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
//    }
//    view.textViewTwitter.setOnClickListener {
//        Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show()
//    }
//    view.textViewInstagram.setOnClickListener {
//        Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show()
//    }
//    view.textViewLinkedin.setOnClickListener {
//        Toast.makeText(this, "Linkedin", Toast.LENGTH_SHORT).show()
//    }
//    dialog.show()
//}