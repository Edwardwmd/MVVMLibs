package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemSquarecardcollectionBinding

class SquareCardCollectionProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.SQUARE_CARD_COLLECTION

    override val layoutId: Int
        get() = R.layout.item_squarecardcollection

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemSquarecardcollectionBinding>(viewHolder.itemView)
    }


    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {

    }

}
