package com.edw.mvvmlibs.net.repository

import android.os.Looper
import android.util.Log
import com.edw.mvvmlibs.bean.Categories
import com.edw.mvvmlibs.bean.HomeBaseItem
import com.edw.mvvmlibs.bean.ResultData
import com.edw.mvvmlibs.net.api.ApiServices
import com.edw.mvvmlibs.net.client.RetrofitClient
import com.edw.mvvmlibs.utils.ThreadUtils

/**
 * Author: EdwardWMD
 * Data: 2021/3/14
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class HomeRepository constructor(private val retrofit:RetrofitClient) {

    //首页-发现
    suspend fun discovery(): ResultData<HomeBaseItem> {
        Log.e(
            "当前线程---->",
            "当前线程ID:${Thread.currentThread().id} 当前线程是否为主线程: ${ThreadUtils.isMainThread()}"
        )
        return retrofit.create(ApiServices::class.java).discovery()
    }
    //首页-推荐
    suspend fun allRec(page: Int): ResultData<HomeBaseItem> {
        return retrofit.create(ApiServices::class.java).allRec(page)
    }

    //首页日报
    suspend fun feed(date: Long, num: Int): ResultData<HomeBaseItem> {
        return retrofit.create(ApiServices::class.java).feed(date, num)
    }

    suspend fun categories():MutableList<Categories>{
        return RetrofitClient.instance.create(ApiServices::class.java).categories()
    }

}