package com.edw.mvvmlibs.adapter.provide

import android.util.Log

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.databinding.ItemBirefcardBinding


import com.edw.mvvmlibs.entity.BriefCard
import com.edw.mvvmlibs.entity.HomeBaseItem


class BriefCardProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.BRIEF_CARD

    override val layoutId: Int
        get() = R.layout.item_birefcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemBirefcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
        val binding: ItemBirefcardBinding? = DataBindingUtil.getBinding(helper.itemView)
        val briefCard = item.data as BriefCard
        Log.e("BriefCardProvider-->", briefCard.icon!!)
        binding?.apply {
            birefcard = briefCard
            executePendingBindings()
        }
    }

}
