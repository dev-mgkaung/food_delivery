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

