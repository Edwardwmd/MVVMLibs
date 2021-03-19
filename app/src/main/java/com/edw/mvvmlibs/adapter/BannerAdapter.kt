package com.edw.mvvmlibs.adapter


import androidx.databinding.DataBindingUtil
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.databinding.ItemBannerBinding
import com.edw.mvvmlibs.entity.HorizontalScrollCard
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder


/**
 * Author: EdwardWMD
 * Data: 2021/3/18
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class BannerAdapter : BaseBannerAdapter<HorizontalScrollCard.Item>() {


    override fun bindData(
        holder: BaseViewHolder<HorizontalScrollCard.Item>?,
        data: HorizontalScrollCard.Item?,
        position: Int,
        pageSize: Int
    ) {

        val binding:ItemBannerBinding ?= DataBindingUtil.bind(holder!!.itemView)
        binding?.apply {
            banner = data
            executePendingBindings()
        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_banner
    }


}