package com.example.fooddeliveryapp.viewholders

import android.view.View
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.PopularViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_popular_choice.view.*
import mk.padc.share.utils.ImageUtils
import mk.padc.share.views.viewholders.BaseViewHolder


class PopularChoiceViewHolder(itemView: View, private val mDelegate: PopularViewItemActionDelegate) :
    BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tv_food_description.text =data.food_description
            itemView.tv_food_rating.text =data.food_rating
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_fooditem,it)
            }
        }
    }
}