package com.edw.mvvmlibs.adapter

import android.util.Log
import androidx.databinding.DataBindingUtil
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.databinding.ItemSquarecardcollectionBannerBinding
import com.edw.mvvmlibs.entity.CollectionItemCard
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 * Author: EdwardWMD
 * Data: 2021/3/23
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class SquareBannerAdapter : BaseBannerAdapter<CollectionItemCard.Item>() {
    override fun bindData(
        holder: BaseViewHolder<CollectionItemCard.Item>?,
        data: CollectionItemCard.Item?,
        position: Int,
        pageSize: Int
    ) {
        val binding:ItemSquarecardcollectionBannerBinding? =
            DataBindingUtil.bind(holder!!.itemView)
        binding?.run {
            Log.e("squarecard---->","imageUrl--->${data!!.data!!.image}")
            this.squareCardCollection =data!!.data
            executePendingBindings()
        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_squarecardcollection_banner
    }


}

