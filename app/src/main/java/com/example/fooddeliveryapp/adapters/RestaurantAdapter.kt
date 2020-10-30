package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.delegates.RestaurantViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.RestaurantViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter


class RestaurantAdapter(private val mDelegate: RestaurantViewItemActionDelegate, private val mviewType: Int) :
        BaseRecyclerAdapter<RestaurantViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return when (mviewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_restaurant_horizontal_viewtype, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_restaurant_vertical_viewtype, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }
        }
    }
}


