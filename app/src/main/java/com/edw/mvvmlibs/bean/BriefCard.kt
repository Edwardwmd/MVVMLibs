package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * BriefCard
 */
 class BriefCard{
    val actionUrl: String?=null
    val adTrack: String?=null
    val dataType: String?=null
    val description: String?=null
    val expert: Boolean=false
    val follow: Follow?=null
    val icon: String?=null
    val iconType: String?=null
    val id: Int=0
    val ifPgc: Boolean=false
    val ifShowNotificationIcon: Boolean=false
    val subTitle: String?=null
    val title: String?=null
    val uid: Int=0

    data class Follow(
        val followed: Boolean = false,
        val itemId: Int = 0,
        val itemType: String? = null
    )
 }



