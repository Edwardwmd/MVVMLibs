package com.edw.mvvmlibs.adapter.secondryadapter

import androidx.recyclerview.widget.LinearLayoutManager
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.base.BaseRecyAdapter
import com.edw.mvvmlibs.databinding.ItemLeveVideocollectionwithbriefBinding
import com.edw.mvvmlibs.entity.CollectionItemCard

/**
 * Author: EdwardWMD
 * Data: 2021/3/24
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class VideoCollectionWithBriefLevelAdapter :
    BaseRecyAdapter<CollectionItemCard.Item, ItemLeveVideocollectionwithbriefBinding>() {
    override fun layoutRes(): Int {
        return R.layout.item_leve_videocollectionwithbrief
    }

    override fun onBindItem(
        binding: ItemLeveVideocollectionwithbriefBinding?,
        itemBean: CollectionItemCard.Item?,
        position: Int
    ) {
        val adapter = VideoCollectionWithBriefFooterAdapter()
        val tags = itemBean!!.data!!.tags

        binding?.run {
            recyVcwbLevel.layoutManager =
                LinearLayoutManager(root.context, LinearLayoutManager.VERTICAL, false)
            recyVcwbLevel.setHasFixedSize(true)
            recyVcwbLevel.adapter = adapter
            if (tags != null && tags.size > 0) {
                adapter.setAllDatas(tags)
            }
            this.videoCollectionWithBriefData = itemBean.data
            executePendingBindings()
        }
    }


}