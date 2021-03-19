package com.edw.mvvmlibs.entity

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: DynamicInfoCard
 */
class DynamicInfoCard:BaseTypeBean() {
    val actionUrl: String? = null
    val createDate: Long = 0
    val dataType: String? = null
    val dynamicType: String? = null
    val merge: Boolean = false
    val mergeNickName: String? = null
    val mergeSubTitle: String? = null
    val reply: Reply? = null
    val simpleVideo: SimpleVideo? = null
    val text: String? = null
    val user: Reply.User? = null


    class Reply {
        val id: Long = 0
        val ifHotReply: Boolean = false
        val likeCount: Int = 0
        val liked: Boolean = false
        val message: String? = null
        val parentReply: String? = null
        val parentReplyId: Int = 0
        val rootReplyId: Long = 0
        val showConversationButton: Boolean = false
        val user: User? = null
        val videoId: Int = 0
        val videoTitle: String? = null

        class User {
            val actionUrl: String? = null
            val area: String? = null
            val avatar: String? = null
            val birthday: Long = 0
            val city: String? = null
            val country: String? = null
            val cover: String? = null
            val description: String? = null
            val expert: Boolean = false
            val followed: Boolean = false
            val gender: String? = null
            val ifPgc: Boolean = false
            val job: String? = null
            val library: String? = null
            val limitVideoOpen: Boolean = false
            val nickname: String? = null
            val registDate: Long = 0
            val releaseDate: Long = 0
            val uid: Int = 0
            val university: String? = null
            val userType: String? = null
        }
    }


    class SimpleVideo {
        val actionUrl: String? = null
        val category: String? = null
        val collected: Boolean = false
        val consumption: String? = null
        val count: Int = 0
        val cover: FollowCard.Content.Data.Cover? = null
        val description: String? = null
        val duration: Int = 0
        val id: Int = 0
        val onlineStatus: String? = null
        val playUrl: String? = null
        val releaseTime: Long = 0
        val resourceType: String? = null
        val title: String? = null
        val uid: Int = 0

        class Cover {
            val blurred: String? = null
            val detail: String? = null
            val feed: String? = null
            val homepage: String? = null
            val sharing: String? = null
        }
    }
}
