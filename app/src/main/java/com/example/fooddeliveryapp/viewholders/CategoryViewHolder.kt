package com.example.fooddeliveryapp.viewholders

import android.view.View
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.delegates.CategoryViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_category_item.view.*
import mk.padc.share.utils.ImageUtils
import mk.padc.share.views.viewholders.BaseViewHolder

class CategoryViewHolder(itemView: View, private val mDelegate: CategoryViewItemActionDelegate) :
        BaseViewHolder<CategoryVO>(itemView) {

    override fun bindData(data: CategoryVO) {
       data?.let {
           itemView.tv_category.text =data.category_name
           data?.category_image?.let{
               ImageUtils().showImageWithoutCrop(itemView.img_category,it)
           }

       }
    }
}