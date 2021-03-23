package com.edw.mvvmlibs.adapter

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.base.BaseRecyAdapter
import com.edw.mvvmlibs.databinding.ItemVideosmallfooterBinding
import com.edw.mvvmlibs.entity.VideoSmallCard

/**
 * Author: EdwardWMD
 * Data: 2021/3/21
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class VideoSmallFooterAdapter :
    BaseRecyAdapter<VideoSmallCard.Tag, ItemVideosmallfooterBinding>() {
    override fun layoutRes(): Int {
        return R.layout.item_videosmallfooter
    }

    override fun onBindItem(
        binding: ItemVideosmallfooterBinding?,
        itemBean: VideoSmallCard.Tag?,
        position: Int
    ) {
        binding?.apply {
            videosmall = itemBean
            executePendingBindings()
        }
    }


}