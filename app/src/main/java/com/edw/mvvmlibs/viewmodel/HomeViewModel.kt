package com.edw.mvvmlibs.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.mvvmlibs.bean.HomeBaseItem
import com.edw.mvvmlibs.bean.ResultData

import com.edw.mvvmlibs.net.repository.HomeRepository
import com.edw.mvvmlibs.utils.LoadState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.StringBuilder

class HomeViewModel : ViewModel() {

    companion object {
        val DEFAULT_PAGE: Int = 0
    }


    fun loadData() {

        loadState.value = LoadState.LOADING
        //加载第一页数据
        viewModelScope.launch(Dispatchers.IO) {
            var result: ResultData<HomeBaseItem>? = null
            result = HomeRepository.discovery()
            val sb=StringBuilder()
            result.itemList.forEach {
                sb.append("数据----------------->").append("$it")
            }
            withContext(Dispatchers.Main) {
                Log.e("HomeViewModel---->", "获取的数据条目数--------->${result.itemList.size}    $sb")
            }
        }

    }

    //加载状态
    val loadState by lazy {
        MutableLiveData<LoadState>()
    }

    //加载数据列表
    val contentList by lazy {
        MutableLiveData<MutableList<ResultData<HomeViewModel>>>()
    }


}
