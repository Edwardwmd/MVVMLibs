package com.edw.mvvmlibs.entity


/**
 * Author: EdwardWMD
 * Data: 2021/3/12
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: ResultData
 */
class ResultData<T> constructor() :
    BaseTypeBean() {

    var adExist: Boolean = false
    var count: Int = 0
    var itemList: MutableList<T>? = null
    var nextPageUrl: String? = null
    var total: Int = 0

    constructor(
        adExist: Boolean,
        count: Int,
        itemList: MutableList<T>? = null,
        nextPageUrl: String,
        total: Int
    ) : this() {
        this.adExist = adExist
        this.count = count
        this.nextPageUrl = nextPageUrl
        this.total = total
        this.itemList = itemList
    }


}

