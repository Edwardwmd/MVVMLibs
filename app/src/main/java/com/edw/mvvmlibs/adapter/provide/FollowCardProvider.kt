package com.edw.mvvmlibs.adapter.provide


import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.adapter.secondryadapter.FollowTypeFooterAdapter
import com.edw.mvvmlibs.databinding.ItemFollowcardBinding


import com.edw.mvvmlibs.entity.HomeBaseItem

import com.edw.mvvmlibs.entity.FollowCard

class FollowCardProvider : BaseItemProvider<HomeBaseItem>() {
    override val itemViewType: Int
        get() = CardViewType.FOLLOW_CARD

    override val layoutId: Int
        get() = R.layout.item_followcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemFollowcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
        item.data?.apply {
            val binding: ItemFollowcardBinding? = DataBindingUtil.getBinding(helper.itemView)
            val followCard = this as FollowCard
            val tags = followCard.content!!.data!!.tags

            binding?.apply {
                if (tags != null && tags.size > 0) {
                    val adapter = FollowTypeFooterAdapter()
                    val linearLayoutManager = LinearLayoutManager(root.context)
                    recyFollow.layoutManager = linearLayoutManager

                    recyFollow.setHasFixedSize(true)
                    recyFollow.adapter = adapter
                    adapter.setAllDatas(tags)
                }
                followcard = followCard
                executePendingBindings()

            }
        }

    }

}
