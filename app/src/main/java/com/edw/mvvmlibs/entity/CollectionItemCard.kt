package com.edw.mvvmlibs.entity

/**
 * Author: EdwardWMD
 * Data: 2021/3/23
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: squareCardCollection 和 videoCollectionWithBrief
 */
class CollectionItemCard : BaseTypeBean() {

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
        val follow: VideoSmallCard.Author.Follow? = null
        val icon: String? = null
        val iconType: String? = null
        val id: Int = 0
        val ifPgc: Boolean = false
        val ifShowNotificationIcon: Boolean = false
        val subTitle: String? = null
        val title: String? = null
        val uid: Int = 0
        val font: String? = null
        val subTitleFont: String? = null
        val textAlign: String? = null
        val cover: String? = null
        val label: String? = null
        val labelList: MutableList<String>? = null
        val rightText: String? = null
        val time: Long = 0
        val showHateVideo: String? = null

    }

    class Item {
        val adIndex: Int = 0
        val data: Data? = null
        val id: Int = 0
        val tag: String? = null
        val trackingData: String? = null
        val type: String? = null


        class Data {
            val image: String? = null
            val actionUrl: String? = null
            val shade: Boolean = false
            val header: Header? = null
            val autoPlay: Boolean = false
            val content:FollowCard.Content?=null


            val ad: Boolean = false
            val adTrack: MutableList<String>? = null
            val author: Author? = null
            val brandWebsiteInfo: String? = null
            val campaign: String? = null
            val category: String? = null
            val collected: Boolean = false
            val consumption: Consumption? = null
            val cover: Cover? = null
            val dataType: String? = null
            val date: Long = 0
            val description: String? = null
            val descriptionEditor: String? = null
            val descriptionPgc: String? = null
            val duration: Int = 0
            val favoriteAdTrack: String? = null
            val id: Int = 0
            val idx: Int = 0
            val ifLimitVideo: Boolean = false
            val label: HorizontalScrollCard.Item.Data.Label? = null
            val labelList: MutableList<String>? = null
            val lastViewTime: String? = null
            val library: String? = null
            val playInfo: MutableList<PlayInfo>? = null
            val playUrl: String? = null
            val played: Boolean = false
            val playlists: String? = null
            val promotion: String? = null
            val provider: Provider? = null
            val reallyCollected: Boolean = false
            val recallSource: String? = null
            val recall_source: String? = null
            val releaseTime: Long = 0
            val remark: String? = null
            val resourceType: String? = null
            val searchWeight: Int = 0
            val shareAdTrack: String? = null
            val slogan: String? = null
            val src: String? = null
            val subtitles: MutableList<String>? = null
            val tags: MutableList<Tag>? = null
            val thumbPlayUrl: String? = null
            val title: String? = null
            val titlePgc: String? = null
            val type: String? = null
            val videoPosterBean: VideoPosterBean? = null
            val waterMarks: String? = null
            val webAdTrack: String? = null
            val webUrl: WebUrl? = null


            class Author {
                val adTrack: String? = null
                val approvedNotReadyVideoCount: Int = 0
                val description: String? = null
                val expert: Boolean = false
                val follow: Follow? = null
                val icon: String? = null
                val id: Int = 0
                val ifPgc: Boolean = false
                val latestReleaseTime: Long = 0
                val link: String? = null
                val name: String? = null
                val recSort: Int = 0
                val shield: Shield? = null
                val videoNum: Int = 0

                class Shield {
                    val itemId: Int = 0
                    val itemType: String? = null
                    val shielded: Boolean = false
                }

                class Follow {
                    val followed: Boolean = false
                    val itemId: Int = 0
                    val itemType: String? = null
                }

            }

            class Consumption {
                val collectionCount: Int = 0
                val realCollectionCount: Int = 0
                val replyCount: Int = 0
                val shareCount: Int = 0
            }

            class Cover {
                val blurred: String? = null
                val detail: String? = null
                val feed: String? = null
                val homepage: String? = null
                val sharing: String? = null
            }

            class PlayInfo {
                val height: Int = 0
                val name: String? = null
                val type: String? = null
                val url: String? = null
                val urlList: MutableList<Url>? = null
                val width: Int = 0

                class Url {
                    val name: String? = null
                    val size: Int = 0
                    val url: String? = null
                }
            }

            class Provider {
                val alias: String? = null
                val icon: String? = null
                val name: String? = null
            }


            class Tag {
                val actionUrl: String? = null
                val adTrack: String? = null
                val bgPicture: String? = null
                val childTagIdList: String? = null
                val childTagList: String? = null
                val communityIndex: Int = 0
                val desc: String? = null
                val haveReward: Boolean = false
                val headerImage: String? = null
                val id: Int = 0
                val ifNewest: Boolean = false
                val name: String? = null
                val newestEndTime: String? = null
                val tagRecType: String? = null
            }


            class VideoPosterBean {
                val fileSizeStr: String? = null
                val scale: Double = 0.0
                val url: String? = null
            }


            class WebUrl {
                val forWeibo: String? = null
                val raw: String? = null
            }

        }


    }

}