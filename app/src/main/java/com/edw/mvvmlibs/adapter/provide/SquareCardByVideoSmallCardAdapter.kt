package com.edw.mvvmlibs.adapter.provide

import androidx.recyclerview.widget.LinearLayoutManager
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.secondryadapter.VideoSmallFooterAdapter
import com.edw.mvvmlibs.adapter.base.BaseRecyAdapter
import com.edw.mvvmlibs.databinding.ItemVideosmallcardBinding
import com.edw.mvvmlibs.entity.CollectionItemCard

class SquareCardByVideoSmallCardAdapter :
    BaseRecyAdapter<CollectionItemCard.Item, ItemVideosmallcardBinding>() {
    override fun layoutRes(): Int {
        return R.layout.item_videosmallcard
    }

    override fun onBindItem(
        binding: ItemVideosmallcardBinding?,
        itemBean: CollectionItemCard.Item?,
        position: Int
    ) {
        itemBean?.data?.content?.apply {
            val videoSmallCard = this.data!!
            val tags = videoSmallCard.tags
            val adapter = VideoSmallFooterAdapter()

            binding?.apply {
                if (tags != null && tags.size > 0) {
                    recyVideosmall.layoutManager = LinearLayoutManager(root.context)
                    recyVideosmall.setHasFixedSize(true)
                    recyVideosmall.adapter = adapter
                    adapter.setAllDatas(tags)
                }
                binding.videoSmallCardBean = videoSmallCard
                executePendingBindings()
            }
        }
    }


}
