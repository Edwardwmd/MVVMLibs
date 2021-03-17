package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
 class VideoCollectionWithBrief {
    val adTrack: String?=null
    val count: Int=0
    val dataType: String?=null
    val footer: String?=null
    val header: Header?=null
    val itemList: MutableList<Item>?=null



    data class Header(
        val actionUrl: String,
        val adTrack: String,
        val description: String,
        val expert: Boolean,
        val follow: FollowCard.Follow,
        val icon: String,
        val iconType: String,
        val id: Int,
        val ifPgc: Boolean,
        val ifShowNotificationIcon: Boolean,
        val subTitle: String,
        val title: String,
        val uid: Int
    )

    data class Item(
        val adIndex: Int,
        val data: FollowCard.Data,
        val id: Int,
        val tag: String,
        val trackingData: String,
        val type: String
    )


}
