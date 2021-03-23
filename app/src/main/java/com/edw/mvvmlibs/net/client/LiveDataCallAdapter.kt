package com.edw.mvvmlibs.net.client

import androidx.lifecycle.LiveData
import com.edw.mvvmlibs.entity.ResultData
import com.google.android.play.core.splitinstall.c
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Author: EdwardWMD
 * Data: 2021/3/21
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 封装LDataCallAdapter
 */
@Suppress("UNCHECKED_CAST")
open class LiveDataCallAdapter<T> constructor(responseType: Type) :
    CallAdapter<T, LiveData<T>> {

    private var responseType: Type? = null


    init {
        this.responseType = responseType
    }

    override fun responseType(): Type {
        return this.responseType!!
    }


    override fun adapt(call: Call<T>): LiveData<T> {
        return RetrofitLiveData(call)
    }

    inner class RetrofitLiveData constructor(call: Call<T>) : LiveData<T>() {

        private var start: AtomicBoolean? = AtomicBoolean(false)

        private var call: Call<T>? = null

        init {
            this.call = call
        }

        override fun onActive() {
            super.onActive()
            if (start!!.compareAndSet(false, true)) {
                call!!.enqueue(object : Callback<T> {
                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        val body: T = response.body() as T
                        postValue(body)
                    }

                    override fun onFailure(call: Call<T>, t: Throwable) {
                        val resultData = ResultData<T>(false, 0, null,"", 0) as T
                        postValue(resultData)
                    }

                })
            }
        }

    }
}