package com.edw.mvvmlibs.entity

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: SquareCardCollection
 */
class SquareCardCollection:BaseTypeBean() {
    val adTrack: String? = null
    val count: Int = 0
    val dataType: String? = null
    val footer: String? = null
    val header: Header? = null
    val itemList: MutableList<HorizontalScrollCard.Item>? = null


    class Header {
        val actionUrl: String? = null
        val cover: String? = null
        val font: String? = null
        val id: Int = 0
        val label: String? = null
        val labelList: String? = null
        val rightText: String? = null
        val subTitle: String? = null
        val subTitleFont: String? = null
        val textAlign: String? = null
        val title: String? = null
    }

}
