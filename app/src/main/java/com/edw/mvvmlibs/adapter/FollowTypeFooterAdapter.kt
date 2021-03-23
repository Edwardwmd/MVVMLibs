package com.edw.mvvmlibs.adapter

import androidx.databinding.ViewDataBinding
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.base.BaseRecyAdapter
import com.edw.mvvmlibs.databinding.ItemFolllowTagBinding
import com.edw.mvvmlibs.entity.FollowCard
import com.edw.mvvmlibs.entity.VideoSmallCard

/**
 * Author: EdwardWMD
 * Data: 2021/3/20
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class FollowTypeFooterAdapter : BaseRecyAdapter<VideoSmallCard.Tag, ItemFolllowTagBinding>() {
    override fun layoutRes(): Int {
        return R.layout.item_folllow_tag
    }

    override fun onBindItem(
        binding: ItemFolllowTagBinding?,
        itemBean: VideoSmallCard.Tag?,
        position: Int
    ) {
        binding?.apply {
            tags = itemBean
            executePendingBindings()
        }

    }


}