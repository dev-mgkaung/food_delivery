package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.DetailViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.DetailViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter

class DetailAdapter(private val mDelegate: DetailViewItemActionDelegate) :
    BaseRecyclerAdapter<DetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_detail_fooditem_layout, parent, false)
        return DetailViewHolder(view, mDelegate)

    }
}
