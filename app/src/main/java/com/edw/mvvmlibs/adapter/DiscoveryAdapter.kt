package com.edw.mvvmlibs.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.edw.mvvmlibs.adapter.provide.*
import com.edw.mvvmlibs.entity.HomeBaseItem

/**
 * Author: EdwardWMD
 * Data: 2021/3/18
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class DiscoveryAdapter: BaseProviderMultiAdapter<HomeBaseItem>(), LoadMoreModule {



   init {
       addItemProvider(HorizontalScrollCardProvider())
       addItemProvider(TextCardProvide())
       addItemProvider(BriefCardProvider())
       addItemProvider(FollowCardProvider())
       addItemProvider(VideoSmallCardProvider())
       addItemProvider(SquareCardCollectionProvider())
       addItemProvider(VideoCollectionWithBriefProvider())
       addItemProvider(DynamicInfoCardProvider())
       addItemProvider(NoTypeCardProvider())
   }


    override fun getItemType(data: List<HomeBaseItem>, position: Int): Int {
        when {
            ("horizontalScrollCard".contains(data[position].type!!)) or (data[position].type == "horizontalScrollCard") -> {
                return CardViewType.HORIZONTAL_SCROLL_CARD
            }
            ("textCard".contains(data[position].type!!)) or (data[position].type == "textCard") -> {
                return CardViewType.TEXT_CARD
            }
            ("briefCard".contains(data[position].type!!)) or (data[position].type == "briefCard") -> {
                return CardViewType.BRIEF_CARD
            }
            ("followCard".contains(data[position].type!!)) or (data[position].type == "followCard") -> {
                return CardViewType.FOLLOW_CARD
            }
            ("videoSmallCard".contains(data[position].type!!)) or (data[position].type == "videoSmallCard") -> {
                return CardViewType.VIDEO_SMALL_CARD
            }
            ("squareCardCollection".contains(data[position].type!!)) or (data[position].type == "squareCardCollection") -> {
                return CardViewType.SQUARE_CARD_COLLECTION
            }
            ("videoCollectionWithBrief".contains(data[position].type!!)) or (data[position].type == "videoCollectionWithBrief") -> {
                return CardViewType.VIDEO_COLLECTION_WITH_BRIEF
            }
            ("DynamicInfoCard".contains(data[position].type!!)) or (data[position].type == "DynamicInfoCard") -> {
                return CardViewType.DYNAMIC_INFO_CARD
            }
            else -> {
                return CardViewType.NO_TYPE_CARD
            }
        }
    }
}