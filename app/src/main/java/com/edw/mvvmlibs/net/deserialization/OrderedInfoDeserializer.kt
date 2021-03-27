package com.edw.mvvmlibs.net.deserialization

import android.util.Log
import com.edw.mvvmlibs.entity.*
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * Author: EdwardWMD
 * Data: 2021/3/19
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 实现JSON反序列化
 */
open class OrderedInfoDeserializer : JsonDeserializer<BaseTypeBean> {
    private val TAG = this.javaClass.simpleName
    private val HORIZONTALSCROLLCARD = "HorizontalScrollCard"
    private val TEXTCARD = "TextCard"
    private val BRIEFCARD = "BriefCard"
    private val FOLLOWCARD = "FollowCard"
    private val VIDEOSMALLCARD = "VideoBeanForClient"
    private val ITEMCOLLECTION = "ItemCollection"  //squareCardCollection 和 videoCollectionWithBrief
    private val DYNAMICINFOCARD = "DynamicInfoCard"
    private val BANNER2 = "banner2"
    private val VIDEO = "video"

    //根据type通过反序列的形式将Json数据指定到对应的类型中
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseTypeBean? {
        try {
            val numericField = json!!.asJsonObject.get("dataType").asString

            return if (HORIZONTALSCROLLCARD == numericField) {
                Gson().fromJson(json, HorizontalScrollCard::class.java)
            } else if (TEXTCARD == numericField) {
                Gson().fromJson(json, TextCard::class.java)
            } else if (BRIEFCARD == numericField) {
                Gson().fromJson(json, BriefCard::class.java)
            } else if (FOLLOWCARD == numericField) {
                Gson().fromJson(json, FollowCard::class.java)
            } else if (VIDEOSMALLCARD == numericField) {
                Gson().fromJson(json, VideoSmallCard::class.java)
            } else if (ITEMCOLLECTION == numericField) { //banner2  video
                Gson().fromJson(json, CollectionItemCard::class.java)
            } else {
                Gson().fromJson(json, DynamicInfoCard::class.java)
            }

        } catch (e: Exception) {
         Log.e(TAG,e.message.toString())
        }

        return null
    }
}