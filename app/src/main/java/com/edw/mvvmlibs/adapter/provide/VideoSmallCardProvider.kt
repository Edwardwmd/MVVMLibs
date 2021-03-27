package com.edw.mvvmlibs.adapter.provide

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.CardViewType
import com.edw.mvvmlibs.adapter.secondryadapter.VideoSmallFooterAdapter
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.databinding.ItemVideosmallcardBinding
import com.edw.mvvmlibs.entity.VideoSmallCard

class VideoSmallCardProvider : BaseItemProvider<HomeBaseItem>() {

    override val itemViewType: Int
        get() = CardViewType.VIDEO_SMALL_CARD

    override val layoutId: Int
        get() = R.layout.item_videosmallcard

    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemVideosmallcardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: HomeBaseItem) {
        val binding = DataBindingUtil.getBinding<ItemVideosmallcardBinding>(helper.itemView)
       item.apply {
           val videoSmallCard = item.data!! as VideoSmallCard
           val tags = videoSmallCard.tags
           val adapter = VideoSmallFooterAdapter()

           binding?.apply {
               if (tags != null && tags.size > 0) {
                   recyVideosmall.layoutManager = LinearLayoutManager(root.context)
                   recyVideosmall.setHasFixedSize(true)
                   recyVideosmall.adapter = adapter
                   adapter.setAllDatas(tags)
               }
               binding.videoSmallCardBean =videoSmallCard
               executePendingBindings()
           }
       }

    }

}
