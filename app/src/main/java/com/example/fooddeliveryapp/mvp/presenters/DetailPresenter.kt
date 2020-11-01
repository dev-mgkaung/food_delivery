package com.example.fooddeliveryapp.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.delegates.DetailViewItemActionDelegate
import com.example.fooddeliveryapp.delegates.PopularChoiceDeatilViewItemActionDelegate
import com.example.fooddeliveryapp.mvp.views.DetailView
import mk.padc.share.mvp.presenters.BasePresenter

interface DetailPresenter : BasePresenter<DetailView>,
    DetailViewItemActionDelegate,
    PopularChoiceDeatilViewItemActionDelegate {

    fun onRestaurantRecieved(context: Context, lifecycleOwner: LifecycleOwner, documentId : String)

}