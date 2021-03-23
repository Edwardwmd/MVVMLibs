package com.edw.mvvmlibs.adapter.provide

import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.BannerAdapter
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.adapter.SquareBannerAdapter
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemSquarecardcollectionBinding
import com.edw.mvvmlibs.entity.CollectionItemCard

import com.edw.mvvmlibs.utils.ToastUtils


class SquareCardCollectionProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.SQUARE_CARD_COLLECTION

    override val layoutId: Int
        get() = R.layout.item_squarecardcollection

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemSquarecardcollectionBinding>(viewHolder.itemView)
    }


    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
        val binding = DataBindingUtil.getBinding<ItemSquarecardcollectionBinding>(helper.itemView)
        val squareCardCollection = item.data as CollectionItemCard
        val adapter = SquareBannerAdapter()
        binding?.run {
            val itemList = squareCardCollection.itemList
            if (itemList != null && itemList.size > 0) {

                bannerSquare.setIndicatorVisibility(View.GONE)
                    .setScrollDuration(1200)
                    .setOnPageClickListener { itemView: View, position: Int ->
                        ToastUtils.showToast("点击了->$position")
                    }
                    .setCanLoop(true)
                    .setAdapter(adapter)
                    .create(itemList)
            }
            this.squareCardCollection = squareCardCollection
            executePendingBindings()
        }

    }

}
