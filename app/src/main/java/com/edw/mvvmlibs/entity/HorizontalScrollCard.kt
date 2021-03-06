package com.edw.mvvmlibs.entity

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: HorizontalScrollCard
 */
class HorizontalScrollCard:BaseTypeBean(){
    val count: Int = 0
    val dataType: String? = null
    var itemList: MutableList<Item>? = null

    class Item {
        val adIndex: Int = 0
        val data: Data? = null
        val id: Int = 0
        val tag: String? = null
        val trackingData: String? = null
        val type: String? = null


        class Data {
            val actionUrl: String? = null
            val adTrack: MutableList<String>? = null
            val autoPlay: Boolean = false
            val dataType: String? = null
            val description: String? = null
            val header: Header? = null
            val id: Int = 0
            val image: String? = null
            val label: Label? = null
            val labelList: MutableList<String>? = null
            val shade: Boolean = false
            val title: String? = null

            class Label {
                val card: String? = null
                val detail: String? = null
                val text: String? = null
            }

            class Header {
                val actionUrl: String? = null
                val cover: String? = null
                val description: String? = null
                val font: String? = null
                val icon: String? = null
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

    }


}

