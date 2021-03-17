package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: SquareCardCollection
 */
 class SquareCardCollection {
    val adTrack: String?=null
    val count: Int=0
    val dataType: String?=null
    val footer: String?=null
    val header: Header?=null
    val itemList: MutableList<Item>?=null


    data class Header(
        val actionUrl: String,
        val cover: String,
        val font: String,
        val id: Int,
        val label: String,
        val labelList: String,
        val rightText: String,
        val subTitle: String,
        val subTitleFont: String,
        val textAlign: String,
        val title: String
    )

    data class Item(
        val adIndex: Int,
        val data: Data,
        val id: Int,
        val tag: String,
        val trackingData: String,
        val type: String
    )

    data class Data(
        val actionUrl: String,
        val adTrack: MutableList<String>,
        val autoPlay: Boolean,
        val dataType: String,
        val description: String,
        val header: String,
        val id: Int,
        val image: String,
        val label: Label,
        val labelList: MutableList<String>,
        val shade: Boolean,
        val title: String
    )

    data class Label(
        val card: String,
        val detail: String,
        val text: String
    )
}
