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
import kotlinx.coroutines.*


class DiscoveryViewModel(repository: HomeRepository) : ViewModel(), IViewModel {
    private val TAG = this.javaClass.simpleName

    private var repository: HomeRepository? = null

    init {
        this.repository = repository
    }

    val loadStatus by lazy {
        MutableLiveData<LoadState>()
    }

    val contentData by lazy {
        MutableLiveData<ResultData<HomeBaseItem>>()
    }


    override fun loadData(page: Int, date: Long, num: Int) {
        loadStatus.value = LoadState.LOADING
        try {
            viewModelScope.launch() {
                val result: ResultData<HomeBaseItem> =
                    this@DiscoveryViewModel.repository!!.discovery()

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

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        if (repository != null) {
            repository = null
        }
    }

}
