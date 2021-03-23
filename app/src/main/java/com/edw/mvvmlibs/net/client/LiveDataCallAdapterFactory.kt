package com.edw.mvvmlibs.net.client

import android.util.Log
import androidx.lifecycle.LiveData
import com.edw.mvvmlibs.net.client.LiveDataCallAdapter
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver


/**
 * Author: EdwardWMD
 * Data: 2021/3/21
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class LiveDataCallAdapterFactory<T> : CallAdapter.Factory() {
    private val TAG = this.javaClass.simpleName

    @SuppressWarnings("ClassGetClass")
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java) {
            return null
        }

        //获取第一个泛型类型
        val type = getParameterUpperBound(0, returnType as ParameterizedType)

        val rawType = getRawType(type)
        Log.d(TAG, "rawType = " + rawType.javaClass.simpleName)
        if (type is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        return LiveDataCallAdapter<T>(responseType = type)
    }

}