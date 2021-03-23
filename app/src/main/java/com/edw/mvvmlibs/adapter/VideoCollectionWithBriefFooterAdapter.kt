package com.edw.mvvmlibs.adapter

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.base.BaseRecyAdapter
import com.edw.mvvmlibs.databinding.ItemFooterVideocollectwithbriefBinding
import com.edw.mvvmlibs.entity.CollectionItemCard

/**
 * Author: EdwardWMD
 * Data: 2021/3/23
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class VideoCollectionWithBriefFooterAdapter:BaseRecyAdapter<CollectionItemCard.Item.Data.Tag,ItemFooterVideocollectwithbriefBinding>() {
    override fun layoutRes(): Int {
        return R.layout.item_footer_videocollectwithbrief
    }

    override fun onBindItem(
        binding: ItemFooterVideocollectwithbriefBinding?,
        itemBean: CollectionItemCard.Item.Data.Tag?,
        position: Int
    ) {
        binding?.run {
          this.videoCollectionWithBriefTag=itemBean
        }
    }


}