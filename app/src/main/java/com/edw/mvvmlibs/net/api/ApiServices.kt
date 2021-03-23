package com.edw.mvvmlibs.net.api

import androidx.lifecycle.LiveData
import com.edw.mvvmlibs.entity.Categories
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.entity.ResultData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
interface ApiServices {
    //首页-发现
    @GET("api/v5/index/tab/discovery")
    suspend fun discovery(): ResultData<HomeBaseItem>

    //首页-推荐
    @GET("api/v5/index/tab/allRec")
    suspend fun allRec(@Query("page") page: Int): ResultData<HomeBaseItem>

    //首页-日报
    /**
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1516842000000&num=1
     */
    @GET("api/v5/index/tab/feed")
    suspend fun feed(@Query("date") date: Long, @Query("num") num: Int): ResultData<HomeBaseItem>


    //首页-Category
    @GET("/api/v4/categories")
    suspend fun categories(): MutableList<Categories>

}