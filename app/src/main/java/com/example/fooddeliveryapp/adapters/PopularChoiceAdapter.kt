package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.PopularViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.PopularChoiceViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter

class PopularChoiceAdapter(private val mDelegate: PopularViewItemActionDelegate) :
    BaseRecyclerAdapter<PopularChoiceViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_popular_choice, parent, false)
        return PopularChoiceViewHolder(view, mDelegate)

    }
}

