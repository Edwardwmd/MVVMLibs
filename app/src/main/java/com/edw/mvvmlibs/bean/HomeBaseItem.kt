package com.edw.mvvmlibs.bean

import android.content.ClipData

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 网络请求数据bean类
 */


data class HomeBaseItem(
    val adIndex: Int=0,
    val data: Any?=null,
    val id: Int=0,
    val tag: String?=null,
    val trackingData: String?=null,
    val type: String?=null
)
/**
 * data根据type划分数据: horizontalScrollCard、textCard、briefCard、followCard、
 * videoSmallCard、squareCardCollection、videoCollectionWithBrief、DynamicInfoCard、
 * banner
 * 在RecycleView实现多布局
 */





