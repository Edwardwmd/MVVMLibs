package com.edw.mvvmlibs.entity

import com.google.gson.annotations.SerializedName

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 网络请求数据bean类
 */

//实体类字段名应该通过@SerializedName("")来规范成java标准命名格式。
class HomeBaseItem {
    @SerializedName("adIndex")
    val adIndex: Int = 0

    @SerializedName("data")
    val data: BaseTypeBean? = null

    @SerializedName("id")
    val id: Int = 0

    @SerializedName("tag")
    val tag: String? = null

    @SerializedName("trackingData")
    val trackingData: String? = null

    @SerializedName("type")
    val type: String? = null
}


/**
 * data根据type划分数据: horizontalScrollCard、textCard、briefCard、followCard、
 * videoSmallCard、squareCardCollection、videoCollectionWithBrief、DynamicInfoCard、
 * banner
 * 在RecycleView实现多布局
 */





