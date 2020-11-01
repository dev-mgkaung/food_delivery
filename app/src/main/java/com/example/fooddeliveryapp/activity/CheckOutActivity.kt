package com.example.fooddeliveryapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.adapters.CheckOutAdapter
import com.example.fooddeliveryapp.datas.vos.FoodItemVO
import com.example.fooddeliveryapp.mvp.presenters.CheckoutPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.CheckoutPresenterImpl
import com.example.fooddeliveryapp.mvp.views.CheckoutView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_check_out.*
import kotlinx.android.synthetic.main.checkout_success_layout.view.*
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.*
import mk.padc.share.activities.BaseActivity
import mk.padc.share.utils.ImageUtils

class CheckOutActivity : BaseActivity(), CheckoutView {

    private lateinit var mPresenter: CheckoutPresenter
    private lateinit var mAdapter: CheckOutAdapter
    private lateinit var mOrderList: List<FoodItemVO>

    companion object {
        const val PARM_RESTAURANT_IMAGE = "PARM_RESTAURANT_IMAGE"
        const val PARM_RESTAURANT_NAME = "PARM_RESTAURANT_NAME"
        const val PARM_RESTAURANT_DESRIPTION = "PARM_RESTAURANT_DESRIPTION"
        const val PARM_RESTAURANT_RATING = "PARM_RESTAURANT_RATING"
        fun newIntent(context: Context,
                      restaurant_name: String?, restaurant_description: String?,
                      restaurant_image: String?, restaurant_rating: String?
        ): Intent {
            val intent = Intent(context, CheckOutActivity::class.java)
            intent.putExtra(PARM_RESTAURANT_IMAGE, restaurant_image)
            intent.putExtra(PARM_RESTAURANT_NAME, restaurant_name)
            intent.putExtra(PARM_RESTAURANT_DESRIPTION, restaurant_description)
            intent.putExtra(PARM_RESTAURANT_RATING, restaurant_rating)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        setUpPresenter()
        initView()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun initView() {
        tv_restaurant_name.text = intent.getStringExtra(PARM_RESTAURANT_NAME).toString()
        tv_restaurant_description.text = intent.getStringExtra(PARM_RESTAURANT_DESRIPTION).toString()
        tv_restaurant_rating.text = intent.getStringExtra(PARM_RESTAURANT_RATING).toString()
        intent.getStringExtra(PARM_RESTAURANT_IMAGE)?.let {
            ImageUtils().showImageWithoutCrop(img_restaurant, it)
        }
    }

    private fun setUpActionListener() {
        btn_checkout.setOnClickListener {
            if(mOrderList.isNotEmpty()) {
                showBottomSheetDialog()
            }else
            {
                Toast.makeText(this,"Empty Cart Item",Toast.LENGTH_LONG).show()
            }
        }
        ll_backpress.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.checkout_success_layout, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        view.btn_order_track.setOnClickListener {

                Toast.makeText(this, "Order Track Clicked", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
                mPresenter.onTapCheckout(this,orderList = mOrderList)
                exitActivity()

        }
        view.btn_order_something.setOnClickListener {
            Toast.makeText(this, "Order Cancel Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
        dialog.show()
    }

    private fun exitActivity() {
        this.finish()
    }

    private fun setUpRecyclerView() {

        rc_orderList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mAdapter = CheckOutAdapter(mPresenter)
        rc_orderList.adapter = mAdapter

    }


    private fun setUpPresenter() {
        mPresenter = getPresenter<CheckoutPresenterImpl, CheckoutView>()
        mPresenter.onUiReady(this,this)

    }

    override fun showOrderList(orderList: List<FoodItemVO>) {
        mOrderList = orderList
        mAdapter.setNewData(orderList as MutableList<FoodItemVO>)
    }

    override fun showCalculationCharge(totalPrice: Long) {

        tv_total_Amount.text = "${totalPrice} $"

    }
}