package com.edw.mvvmlibs.entity

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class VideoCollectionWithBrief:BaseTypeBean() {
    val adTrack: String? = null
    val count: Int = 0
    val dataType: String? = null
    val footer: String? = null
    val header: Header? = null
    val itemList: MutableList<Item>? = null


    class Header {
        val actionUrl: String? = null
        val adTrack: String? = null
        val description: String? = null
        val expert: Boolean = false
        val follow: FollowCard.Content.Data.Author.Follow? = null
        val icon: String? = null
        val iconType: String? = null
        val id: Int = 0
        val ifPgc: Boolean = false
        val ifShowNotificationIcon: Boolean = false
        val subTitle: String? = null
        val title: String? = null
        val uid: Int = 0

    }


    class Item {
        val adIndex: Int = 0
        val data: FollowCard.Content.Data? = null
        val id: Int = 0
        val tag: String? = null
        val trackingData: String? = null
        val type: String? = null

    }


}
