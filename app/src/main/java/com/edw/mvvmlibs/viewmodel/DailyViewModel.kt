package com.edw.mvvmlibs.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.entity.ResultData
import com.edw.mvvmlibs.net.repository.HomeRepository
import com.edw.mvvmlibs.utils.LoadState
import com.edw.mvvmlibs.viewmodel.base.IViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class DailyViewModel constructor(repository: HomeRepository) : ViewModel(), IViewModel {

    private val TAG = this.javaClass.simpleName

    private var repository: HomeRepository? = null

    companion object {
        //默认时间戳
        const val DEFAULT_DATE: Long = 1616842172678

        const val DEFAULT_NUM: Int = 0
    }


    init {
        this.repository = repository
    }

    override fun loadData(page: Int, date: Long, num: Int) {
        loadStatus.value = LoadState.LOADING
        try {
            viewModelScope.launch {
                val result = repository!!.daily(
                    if (date <= 0) DEFAULT_DATE else date,
                    if (num <= 0) DEFAULT_NUM else num
                )
                if (result.itemList!!.size > 0) {
                    contentData.value = result
                    loadStatus.value = LoadState.SUCCESS
                    Log.d(TAG, "SUCCESS---> 数据: ${result.itemList}")
                } else {
                    loadStatus.value = LoadState.EMPTY
                    Log.d(TAG, "EMPTY---> 数据: ${result.itemList}")
                }
            }
        } catch (e: Exception) {

            Log.e(TAG, e.message.toString())

            loadStatus.value = LoadState.ERROR
        }
    }

    val loadStatus by lazy {
        MutableLiveData<LoadState>()
    }

    val contentData by lazy {
        MutableLiveData<ResultData<HomeBaseItem>>()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        if (repository != null) {
            repository = null
        }
    }
}
