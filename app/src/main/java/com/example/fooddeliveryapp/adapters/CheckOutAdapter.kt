package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.CheckoutViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter

class CheckOutAdapter(private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseRecyclerAdapter<CheckoutViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_checkout, parent, false)
        return CheckoutViewHolder(view, mDelegate)

    }
}
