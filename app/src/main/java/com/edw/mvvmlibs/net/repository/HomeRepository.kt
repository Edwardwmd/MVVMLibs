package com.edw.mvvmlibs.net.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.edw.mvvmlibs.entity.Categories
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.entity.ResultData
import com.edw.mvvmlibs.net.api.ApiServices
import com.edw.mvvmlibs.net.client.RetrofitClient
import com.edw.mvvmlibs.utils.ThreadUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Author: EdwardWMD
 * Data: 2021/3/14
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class HomeRepository constructor(private val retrofit: RetrofitClient) {

    //首页-发现
    suspend fun discovery(): ResultData<HomeBaseItem> {

        return withContext(Dispatchers.IO) {
            Log.e(
                "协程",
                "当前线程ID:${Thread.currentThread().id} 当前线程是否为主线程: ${ThreadUtils.isMainThread()}"
            )
            retrofit.create(ApiServices::class.java).discovery()
        }
    }

    //首页-推荐
    suspend fun allRec(page: Int): ResultData<HomeBaseItem> {
        return withContext(Dispatchers.IO) {
            retrofit.create(ApiServices::class.java).allRec(page)
        }
    }

    //首页日报
    suspend fun daily(date: Long, num: Int): ResultData<HomeBaseItem> {
        return withContext(Dispatchers.IO) {
            retrofit.create(ApiServices::class.java).daily(date, num)
        }

    }

    suspend fun categories(): MutableList<Categories> {
        return withContext(Dispatchers.IO) {
            RetrofitClient.instance.create(ApiServices::class.java).categories()
        }
    }

}