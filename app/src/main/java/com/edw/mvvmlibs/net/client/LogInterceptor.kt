package com.edw.mvvmlibs.net.client

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

internal class LogInterceptor : Interceptor {
    private val TAG = LogInterceptor::class.simpleName!!
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val startTimeMillis = System.currentTimeMillis()
        val proceed = chain.proceed(request)
        val endTimeMillis = System.currentTimeMillis()
        val createProceedTimes = endTimeMillis - startTimeMillis
        val content = proceed.body!!.toString()
        val contentType = proceed.body!!.contentType()!!
        Log.d(TAG, "Create Proceed Duration--------->$createProceedTimes 毫秒")
        Log.d(TAG, "-----------------------分割线-------------------------")
        Log.d(TAG, "Body------------->$content")

        return proceed
            .newBuilder()
            .body(content.toResponseBody(contentType))
            .build()
    }

}
