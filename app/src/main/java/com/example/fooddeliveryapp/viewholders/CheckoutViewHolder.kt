package com.example.fooddeliveryapp.viewholders

import android.view.View
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_checkout.view.*
import mk.padc.share.utils.ImageUtils
import mk.padc.share.views.viewholders.BaseViewHolder


class CheckoutViewHolder(itemView: View, private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tv_restaurant_name.text =data?.food_name
            itemView.tv_restaurant_description.text = data?.food_description
            itemView.tv_restaurant_rating.text =data?.food_rating
            itemView.tv_restaurant_price.text =data?.food_price+" $"
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_restaurant,it)
            }

        }
    }
}