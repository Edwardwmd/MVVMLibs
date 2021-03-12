package com.edw.mvvmlibs.net.api

import com.edw.mvvmlibs.bean.KaiYanBean
import io.reactivex.rxjava3.core.Observable
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
    fun discovery(): Observable<KaiYanBean>
    //首页-推荐
    @GET("api/v5/index/tab/allRec")
    fun allRec(@Query("page") page: Int): Observable<KaiYanBean>

    //首页-日报
    /**
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1516842000000&num=1
     */
    @GET("api/v5/index/tab/feed")
    fun feed(@Query("date") date: Long, @Query("num") num: Int): Observable<KaiYanBean>



}