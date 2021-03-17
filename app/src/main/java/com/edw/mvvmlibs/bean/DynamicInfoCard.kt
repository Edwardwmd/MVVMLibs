package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: DynamicInfoCard
 */
 class DynamicInfoCard {
    val actionUrl: String?=null
    val createDate: Long=0
    val dataType: String?=null
    val dynamicType: String?=null
    val merge: Boolean=false
    val mergeNickName: String?=null
    val mergeSubTitle: String?=null
    val reply: Reply?=null
    val simpleVideo: SimpleVideo?=null
    val text: String?=null
    val user: User?=null


    data class Reply(
        val id: Long,
        val ifHotReply: Boolean,
        val likeCount: Int,
        val liked: Boolean,
        val message: String,
        val parentReply: String,
        val parentReplyId: Int,
        val rootReplyId: Long,
        val showConversationButton: Boolean,
        val user: User,
        val videoId: Int,
        val videoTitle: String
    )

    data class SimpleVideo(
        val actionUrl: String,
        val category: String,
        val collected: Boolean,
        val consumption: String,
        val count: Int,
        val cover: Cover,
        val description: String,
        val duration: Int,
        val id: Int,
        val onlineStatus: String,
        val playUrl: String,
        val releaseTime: Long,
        val resourceType: String,
        val title: String,
        val uid: Int
    )


    data class User(
        val actionUrl: String,
        val area: String,
        val avatar: String,
        val birthday: Long,
        val city: String,
        val country: String,
        val cover: String,
        val description: String,
        val expert: Boolean,
        val followed: Boolean,
        val gender: String,
        val ifPgc: Boolean,
        val job: String,
        val library: String,
        val limitVideoOpen: Boolean,
        val nickname: String,
        val registDate: Long,
        val releaseDate: Long,
        val uid: Int,
        val university: String,
        val userType: String
    )

    data class Cover(
        val blurred: String,
        val detail: String,
        val feed: String,
        val homepage: String,
        val sharing: String
    )
}
