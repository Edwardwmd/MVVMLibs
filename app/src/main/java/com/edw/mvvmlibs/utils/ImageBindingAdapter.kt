package com.edw.mvvmlibs.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
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
    @JvmStatic //需要添加java的静态注解,从而生成静态方法,不添加此注解会报错
    fun loadImage(iv: ImageView?, url: String?) {
        if (iv != null) {
            url?.apply {
                Glide
                    .with(iv.context)
                    .load(url)
                    .centerCrop()
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .error(R.drawable.ic_launcher_full_screen_pic)
                    .placeholder(R.drawable.ic_launcher_fast_bg)
                    .into(iv)
            }
        }
    }

    @BindingAdapter("circleImageUrl")
    @JvmStatic //需要添加java的静态注解,从而生成静态方法,不添加此注解会报错
    fun loadCircleImage(iv: ImageView?, url: String?) {
        if (iv != null) {
            url?.apply {
                Glide
                    .with(iv.context)
                    .load(url)
                    .skipMemoryCache(false)
                    .error(R.drawable.ic_launcher_fast_bg)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .placeholder(R.drawable.ic_launcher_fast_bg)
                    .into(iv)
            }

        }
    }

    //requireAll = false 表示可以使用这两个两个属性中的任一个或同时使用,默认为true,
    //如果为true时,必须填写两个参数,否则会报错
    @BindingAdapter("roundImageUrl", "round", requireAll = false)
    @JvmStatic //需要添加java的静态注解,从而生成静态方法,不添加此注解会报错
    fun loadRoundImage(iv: ImageView?, url: String?, round: Int=5) {
        if (iv != null) {
            url?.apply {
                Glide
                    .with(iv.context)
                    .load(url)
                    .skipMemoryCache(false)
                    .error(R.drawable.ic_launcher_fast_bg)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(round)))
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .placeholder(R.drawable.ic_launcher_fast_bg)
                    .into(iv)
            }

        }
    }
}