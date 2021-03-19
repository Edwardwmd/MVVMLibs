package com.edw.mvvmlibs.entity


/**
 * Author: EdwardWMD
 * Data: 2021/3/12
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
 class ResultData<T>:BaseTypeBean(){
    val adExist: Boolean=false
    val count: Int=0
    val itemList: MutableList<T>?=null
    val nextPageUrl: String?=null
    val total: Int=0

 }

