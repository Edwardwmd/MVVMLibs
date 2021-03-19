package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemVideosmallcardBinding

class VideoSmallCardProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.VIDEO_SMALL_CARD

    override val layoutId: Int
        get() = R.layout.item_videosmallcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemVideosmallcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {

    }

}
