package com.edw.mvvmlibs.adapter.provide

import android.database.DatabaseUtils
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemNotypecardBinding
import com.edw.mvvmlibs.utils.TextUtils

class

NoTypeCardProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.NO_TYPE_CARD

    override val layoutId: Int
        get() = R.layout.item_notypecard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemNotypecardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
      val binding=DataBindingUtil.getBinding<ItemNotypecardBinding>(helper.itemView)
        binding?.apply {
            tvNotype.typeface=TextUtils.setTextStyle(TextUtils.Type.LOBSTER)
        }
    }

}
