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
            .addHeader("Content-Encoding", "gzip")
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .addHeader("Server", "Tengine/2.1.2")
            .build()
    }

}
