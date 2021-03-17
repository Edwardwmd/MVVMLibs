package com.edw.mvvmlibs.bean


/**
 * Author: EdwardWMD
 * Data: 2021/3/12
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
data class ResultData<T>(
    val adExist: Boolean,
    val count: Int,
    val itemList: MutableList<T>,
    val nextPageUrl: String?=null,
    val total: Int
)
