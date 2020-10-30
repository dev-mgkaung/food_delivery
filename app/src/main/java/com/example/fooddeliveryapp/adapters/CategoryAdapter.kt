package com.example.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.delegates.CategoryViewItemActionDelegate
import com.example.fooddeliveryapp.viewholders.CategoryViewHolder
import mk.padc.share.adapters.BaseRecyclerAdapter

class CategoryAdapter(private val mDelegate: CategoryViewItemActionDelegate) :
        BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_category_item, parent, false)
                return CategoryViewHolder(view, mDelegate)

        }
    }

