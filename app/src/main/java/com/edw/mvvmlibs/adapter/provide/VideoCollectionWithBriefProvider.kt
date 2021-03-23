package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.adapter.VideoCollectionWithBriefFooterAdapter
import com.edw.mvvmlibs.databinding.ItemVideocollectionwithbriefBinding
import com.edw.mvvmlibs.entity.HomeBaseItem

import com.edw.mvvmlibs.entity.CollectionItemCard

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

        val binding =
            DataBindingUtil.getBinding<ItemVideocollectionwithbriefBinding>(helper.itemView)
        val videoCollectionWithBrief = item.data as CollectionItemCard
        val itemList = videoCollectionWithBrief.itemList

        val adapter = VideoCollectionWithBriefFooterAdapter()

        binding?.run {
            if (itemList != null && itemList.size > 0) {
                recyVcwb.layoutManager =
                    LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
                recyVcwb.setHasFixedSize(true)
                recyVcwb.adapter = adapter
                itemList.forEach {
                    adapter.setAllDatas(it.data!!.tags)
                    this.videoCollectionWithBriefData = it.data
                    executePendingBindings()
                }

            }


        }

    }

}
