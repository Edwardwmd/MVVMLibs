package com.edw.mvvmlibs.net.client

import com.edw.mvvmlibs.entity.BaseTypeBean
import com.edw.mvvmlibs.net.deserialization.OrderedInfoDeserializer
import com.edw.mvvmlibs.net.api.Api
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

import java.util.concurrent.TimeUnit

/**
 * Author: EdwardWMD
 * Data: 2021/3/12
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class RetrofitClient constructor() {
    private var retrofit: Retrofit? = null

    companion object {
        val instance: RetrofitClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitClient()
        }
    }

    init {
        retrofit = Retrofit
            .Builder()
            .client(initOkhttp())
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(initGsonFactory())
            .build()
    }

    private fun initGsonFactory(): Converter.Factory {
        val gson =
            GsonBuilder().registerTypeAdapter(BaseTypeBean::class.java, OrderedInfoDeserializer())
                .create()
        return LenientGsonConverterFactory.create(gson)
    }

    private fun initOkhttp(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(initIntercepter())
            .addInterceptor(CommonInterceptor())
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(20,1,TimeUnit.SECONDS))
            .build()

    }

    private fun initIntercepter(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    //创建apiServices类
    fun <T> create(apiService: Class<T>): T {
        return retrofit!!.create(apiService)
    }

}