package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/17
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: FollowCard
 */
class FollowCard {
    val adTrack: MutableList<String>? = null
    val content: Content? = null
    val dataType: String? = null
    val header: Header? = null


    data class Content(
        val adIndex: Int,
        val data: Data,
        val id: Int,
        val tag: String,
        val trackingData: String,
        val type: String
    )

    data class Header(
        val actionUrl: String,
        val cover: String,
        val description: String,
        val font: String,
        val icon: String,
        val iconType: String,
        val id: Int,
        val label: String,
        val labelList: String,
        val rightText: String,
        val showHateVideo: Boolean,
        val subTitle: String,
        val subTitleFont: String,
        val textAlign: String,
        val time: Long,
        val title: String
    )

    data class Data(
        val ad: Boolean,
        val adTrack: MutableList<String>,
        val author: Author,
        val brandWebsiteInfo: String,
        val campaign: String,
        val category: String,
        val collected: Boolean,
        val consumption: Consumption,
        val cover: Cover,
        val dataType: String,
        val date: Long,
        val description: String,
        val descriptionEditor: String,
        val descriptionPgc: String,
        val duration: Int,
        val favoriteAdTrack: String,
        val id: Int,
        val idx: Int,
        val ifLimitVideo: Boolean,
        val label: String,
        val labelList: MutableList<String>,
        val lastViewTime: String,
        val library: String,
        val playInfo: MutableList<PlayInfo>,
        val playUrl: String,
        val played: Boolean,
        val playlists: String,
        val promotion: String,
        val provider: Provider,
        val reallyCollected: Boolean,
        val recallSource: String,
        val recall_source: String,
        val releaseTime: Long,
        val remark: String,
        val resourceType: String,
        val searchWeight: Int,
        val shareAdTrack: String,
        val slogan: String,
        val src: String,
        val subtitles: MutableList<String>,
        val tags: MutableList<Tag>,
        val thumbPlayUrl: String,
        val title: String,
        val titlePgc: String,
        val type: String,
        val videoPosterBean: VideoPosterBean,
        val waterMarks: String,
        val webAdTrack: String,
        val webUrl: WebUrl
    )

    data class Author(
        val adTrack: String,
        val approvedNotReadyVideoCount: Int,
        val description: String,
        val expert: Boolean,
        val follow: Follow,
        val icon: String,
        val id: Int,
        val ifPgc: Boolean,
        val latestReleaseTime: Long,
        val link: String,
        val name: String,
        val recSort: Int,
        val shield: Shield,
        val videoNum: Int
    )

    data class Consumption(
        val collectionCount: Int,
        val realCollectionCount: Int,
        val replyCount: Int,
        val shareCount: Int
    )

    data class Cover(
        val blurred: String,
        val detail: String,
        val feed: String,
        val homepage: String,
        val sharing: String
    )

    data class PlayInfo(
        val height: Int,
        val name: String,
        val type: String,
        val url: String,
        val urlList: MutableList<Url>,
        val width: Int
    )

    data class Provider(
        val alias: String,
        val icon: String,
        val name: String
    )

    data class Tag(
        val actionUrl: String,
        val adTrack: String,
        val bgPicture: String,
        val childTagIdList: String,
        val childTagList: String,
        val communityIndex: Int,
        val desc: String,
        val haveReward: Boolean,
        val headerImage: String,
        val id: Int,
        val ifNewest: Boolean,
        val name: String,
        val newestEndTime: String,
        val tagRecType: String
    )

    data class VideoPosterBean(
        val fileSizeStr: String,
        val scale: Double,
        val url: String
    )

    data class WebUrl(
        val forWeibo: String,
        val raw: String
    )

    data class Follow(
        val followed: Boolean,
        val itemId: Int,
        val itemType: String
    )

    data class Shield(
        val itemId: Int,
        val itemType: String,
        val shielded: Boolean
    )

    data class Url(
        val name: String,
        val size: Int,
        val url: String
    )

}


