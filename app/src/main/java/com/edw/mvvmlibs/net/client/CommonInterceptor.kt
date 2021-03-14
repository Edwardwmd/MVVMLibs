package com.edw.mvvmlibs.net.client

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(addHeader(chain.request().newBuilder()))
    }

    private fun addHeader(builder: Request.Builder): Request {
        return builder
            .addHeader("udid", "1dad62050ee54c10965021ed1bff209cdee1f09e")
            .addHeader("vc", "256")
            .addHeader("vn", "3.14")
            .addHeader("deviceModel", "MIX%202")
            .addHeader("first_channel", "eyepetizer_yingyongbao_market")
            .addHeader("last_channel", "eyepetizer_yingyongbao_market")
            .addHeader("system_version_code", "25")
            .build()
    }

}
