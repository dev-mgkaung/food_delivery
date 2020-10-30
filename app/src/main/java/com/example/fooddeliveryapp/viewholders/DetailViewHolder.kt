package com.example.fooddeliveryapp.viewholders

import android.view.View
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.DetailViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.*
import mk.padc.share.utils.ImageUtils
import mk.padc.share.views.viewholders.BaseViewHolder

class DetailViewHolder(itemView: View, private val mDelegate: DetailViewItemActionDelegate) :
    BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

            data?.let {
                itemView.tv_restaurant_name.text =data?.food_name
                itemView.tv_restaurant_description.text = data?.food_description
                itemView.tv_restaurant_rating.text =data?.food_rating
                data?.food_image?.let{
                    ImageUtils().showImageWithoutCrop(itemView.img_restaurant,it)
                }
            }
    }
}