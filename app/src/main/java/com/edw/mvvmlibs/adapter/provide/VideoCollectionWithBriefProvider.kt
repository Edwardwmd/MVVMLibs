package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemVideocollectionwithbriefBinding

class

VideoCollectionWithBriefProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.VIDEO_COLLECTION_WITH_BRIEF

    override val layoutId: Int
        get() = R.layout.item_videocollectionwithbrief

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemVideocollectionwithbriefBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {

    }

}
