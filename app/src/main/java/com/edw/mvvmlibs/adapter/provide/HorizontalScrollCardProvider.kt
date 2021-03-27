package com.edw.mvvmlibs.adapter.provide

import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.secondryadapter.BannerAdapter
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemHorizontalscrollcardBinding
import com.edw.mvvmlibs.entity.HorizontalScrollCard
import com.edw.mvvmlibs.utils.ToastUtils

import com.zhpan.bannerview.BannerViewPager


class HorizontalScrollCardProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.HORIZONTAL_SCROLL_CARD

    override val layoutId: Int
        get() = R.layout.item_horizontalscrollcard


    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemHorizontalscrollcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
       val bd: ItemHorizontalscrollcardBinding? = DataBindingUtil.getBinding(helper.itemView)
        val horizontalScrollCard = item.data as HorizontalScrollCard
        Log.e("HorizontalScrollCard-->",horizontalScrollCard.itemList!![0].data!!.image!!)
        val adapter = BannerAdapter()
        bd?.run {
           banner
               .setScrollDuration(1200)//设置项目滚动持续时间
               .setIndicatorVisibility(View.GONE)//指标隐藏
               .setOnPageClickListener(BannerViewPager.OnPageClickListener{ itemView: View, position: Int ->
                  ToastUtils.showToast("当前是第$position 页")
               })
               .setCanLoop(true)
               .setAdapter(adapter)
               .create(horizontalScrollCard.itemList)
       }


    }

}
