package com.edw.mvvmlibs.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.edw.mvvmlibs.R

/**
 * Author: EdwardWMD
 * Data: 2021/3/19
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc:databinding将image url绑定在adapter中
 */
object ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic //这个在Kotlin中必须添加
    fun loadImage(iv: ImageView?, url: String?) {
        if (iv != null && url!!.isNotEmpty()) {
            Glide
                .with(iv.context)
                .load(url)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_launcher_fast_bg)
                .into(iv)
        }
    }

}