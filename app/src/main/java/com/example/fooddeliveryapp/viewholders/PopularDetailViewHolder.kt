package com.example.fooddeliveryapp.viewholders

import android.view.View
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.delegates.PopularChoiceDeatilViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_popular_choice_detail_layout.view.*
import mk.padc.share.utils.ImageUtils
import mk.padc.share.views.viewholders.BaseViewHolder

class PopularDetailViewHolder(itemView: View, private val mDelegate: PopularChoiceDeatilViewItemActionDelegate) :
    BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tv_detail_popularchoice_name.text =data?.food_name
            itemView.tv_detail_popularchoice_price.text =data?.food_price
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_detail_popularchoice,it)
            }
        }
    }
}