package com.example.fooddeliveryapp.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.activity.DetailActivity
import com.example.fooddeliveryapp.adapters.CategoryAdapter
import com.example.fooddeliveryapp.adapters.PopularChoiceAdapter
import com.example.fooddeliveryapp.adapters.RestaurantAdapter
import com.example.fooddeliveryapp.datas.vos.CategoryVO
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.datas.vos.RestaurantVO
import com.example.fooddeliveryapp.mvp.presenters.MainPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.MainPresenterImpl
import com.example.fooddeliveryapp.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_restaurant.*
import mk.padc.share.activities.BaseFragment

 class RestaurantFragment : BaseFragment(), MainView {

    private lateinit var mPresenter: MainPresenter

    private lateinit var mCategoryAdapter: CategoryAdapter
    private lateinit var mRestaurantAdapter: RestaurantAdapter
    private lateinit var mPopularChoiceAdapter: PopularChoiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()
    }
    private fun setUpRecyclerView() {

        rc_category.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rc_popular_choice.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rc_restaurants.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mCategoryAdapter = CategoryAdapter (mPresenter)
        rc_category.adapter = mCategoryAdapter

        mPopularChoiceAdapter = PopularChoiceAdapter (mPresenter)
        rc_popular_choice.adapter = mPopularChoiceAdapter

    }


    private fun setUpPresenter() {
        activity?.let{
            mPresenter = getPresenter<MainPresenterImpl, MainView>()
            mPresenter.onUiReady(this)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun changeHomeScreenViewType(viewType: Int) {
        if(viewType == 0)
        {
            viewTypeOne()
        }else
        {
            viewTypeTwo()
        }
    }

    private fun viewTypeOne()
    {
        location_layout.visibility =View.VISIBLE
        rc_category.visibility = View.VISIBLE
        ly_restaurant.visibility= View.GONE
        ly_popular.visibility =View.GONE
        rc_popular_choice.visibility =View.GONE
        mRestaurantAdapter = RestaurantAdapter (mPresenter,0)
        rc_restaurants.adapter = mRestaurantAdapter

    }
    private fun viewTypeTwo()
    {
        location_layout.visibility =View.GONE
        rc_category.visibility = View.GONE
        ly_restaurant.visibility= View.VISIBLE
        ly_popular.visibility =View.VISIBLE
        rc_popular_choice.visibility =View.VISIBLE
        mRestaurantAdapter = RestaurantAdapter (mPresenter,1)
        rc_restaurants.adapter = mRestaurantAdapter

    }

    override fun navigateToDetailScreen(documentId: String) {
      startActivity(  activity?.applicationContext?.let{DetailActivity.newIntent(it, documentId)})
    }

    override fun showErrorMessage(message: String) {
        //   Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG)
    }

    override fun showCategories(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setNewData(categoryList as MutableList<CategoryVO>)
    }

     override fun showRestaurants(restaurantList: List<RestaurantVO>) {
         mRestaurantAdapter.setNewData(restaurantList as MutableList<RestaurantVO>)
     }

     override fun showPopularChoicesFoodItems(popularChoiceList: List<FoodItemVO>) {
         mPopularChoiceAdapter.setNewData(popularChoiceList as MutableList<FoodItemVO>)
     }

 }