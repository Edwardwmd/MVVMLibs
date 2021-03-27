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

class RecommendViewModel constructor(repository: HomeRepository) : ViewModel(), IViewModel {

    private val TAG = this.javaClass.simpleName

    private var repository: HomeRepository? = null

    init {
        this.repository = repository
    }

    companion object {
        const val DEFAULT_PAGE = 0
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
            viewModelScope.launch {
                val result =
                    this@RecommendViewModel.repository!!.allRec(if (page <= 0) DEFAULT_PAGE else page)
                val itemList = result.itemList!!
                if (itemList.size > 0) {
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
