package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.PopularChoiceDeatilViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.PopularDetailViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter

class PopularChoiceDetailAdapter(private val mDelegate: PopularChoiceDeatilViewItemActionDelegate) :
    BaseRecyclerAdapter<PopularDetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularDetailViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_popular_choice_detail_layout, parent, false)
        return PopularDetailViewHolder(view, mDelegate)

    }
}
