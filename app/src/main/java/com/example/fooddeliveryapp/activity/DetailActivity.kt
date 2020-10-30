package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.adapters.*
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.mvp.presenters.DetailPresenter
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.DetailPresenterImpl
import com.example.fooddeliveryapp.mvp.presenters.impls.MainPresenterImpl
import com.example.fooddeliveryapp.mvp.views.DetailView
import com.example.fooddeliveryapp.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_deatil.*
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_restaurant.*
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.*
import mk.padc.share.activities.BaseActivity
import mk.padc.share.utils.ImageUtils

class DetailActivity : BaseActivity() , DetailView {

    private lateinit var mPresenter: DetailPresenter
    private lateinit var mDetailAdapter: DetailAdapter
    private lateinit var mPopularChoiceDetailAdapter: PopularChoiceDetailAdapter

    companion object {
        const val PARM_DOCUMENTID = "Document ID"
        fun newIntent(context: Context,
                      documentId: String
        ) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PARM_DOCUMENTID, documentId)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatil)
        setUpPresenter()
        setUpRecyclerView()
    }
    private fun setUpRecyclerView() {

        rc_detail_popular_choice.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rc_detail_fooditem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mDetailAdapter = DetailAdapter (mPresenter)
        rc_detail_fooditem.adapter = mDetailAdapter

        mPopularChoiceDetailAdapter = PopularChoiceDetailAdapter (mPresenter)
        rc_detail_popular_choice.adapter = mPopularChoiceDetailAdapter

    }


    private fun setUpPresenter() {
            mPresenter = getPresenter<DetailPresenterImpl, DetailView>()
            mPresenter.onUiReady(this)
            mPresenter.onfetchReastaurantData(this,intent.getStringExtra(PARM_DOCUMENTID).toString())
    }


    override fun showRestaurantData(restaurantVO: RestaurantVO) {
        detail_description.text =restaurantVO?.description
         tv_detail_rating.text =restaurantVO?.rating
        tv_detail_title.text =restaurantVO?.name
        restaurantVO?.image_url?.let{
            ImageUtils().showImageWithoutCrop(detail_image,it)
        }
    }

    override fun showPopularChoicesFoodItem(popularFoodList: List<FoodItemVO>) {
        mPopularChoiceDetailAdapter.setNewData(popularFoodList as MutableList<FoodItemVO>)
    }

    override fun showFoodItemList(foodList: List<FoodItemVO>) {
        mDetailAdapter.setNewData(foodList as MutableList<FoodItemVO>)
    }

}