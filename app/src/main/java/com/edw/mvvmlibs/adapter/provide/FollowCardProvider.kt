package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemFollowcardBinding

class FollowCardProvider : BaseItemProvider<HomeBaseItem>() {
    override val itemViewType: Int
        get() = CardViewType.FOLLOW_CARD

    override val layoutId: Int
        get() = R.layout.item_followcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemFollowcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {

    }


}
