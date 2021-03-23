package com.edw.mvvmlibs.adapter.provide

import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.databinding.ItemTextcardBinding
import com.edw.mvvmlibs.entity.HomeBaseItem

import com.edw.mvvmlibs.entity.TextCard

/**
 * Author: EdwardWMD
 * Data: 2021/3/18
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class TextCardProvide : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.TEXT_CARD

    override val layoutId: Int
        get() = R.layout.item_textcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemTextcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
        val binding: ItemTextcardBinding? = DataBindingUtil.getBinding(helper.itemView)
        val textCard = item.data as TextCard
        Log.e("TextCardProvide-->",textCard.text!!)
        binding?.apply {
            if (textCard.type=="header5"){
                clShowMore.visibility=View.GONE
                tvTxcard.visibility=View.VISIBLE
            }else if (textCard.type=="footer2"){
                clShowMore.visibility=View.VISIBLE
                tvTxcard.visibility=View.GONE
            }

            textcard = textCard
            executePendingBindings()
        }

    }
}