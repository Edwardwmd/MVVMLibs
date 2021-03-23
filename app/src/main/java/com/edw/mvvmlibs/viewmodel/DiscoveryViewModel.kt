package com.edw.mvvmlibs.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.entity.ResultData
import com.edw.mvvmlibs.net.client.NetworkStatusManager
import com.edw.mvvmlibs.net.repository.HomeRepository
import com.edw.mvvmlibs.utils.LoadState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DiscoveryViewModel(private val repository: HomeRepository) : ViewModel() {
    private val TAG = this.javaClass.simpleName

    fun loadData() {
        loadState.value = LoadState.LOADING
        if (NetworkStatusManager.NETWORK_CONNECTED) {
                loadDataByPage()
        } else {
            loadState.value = LoadState.NETWORKDISCONNECTED
        }


    }

    private fun loadDataByPage() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val result: ResultData<HomeBaseItem> = repository.discovery()

                if (result.itemList!!.size > 0) {
                    withContext(Dispatchers.Main) {
                        contentData.value = result
                        loadState.value = LoadState.SUCCESS
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        loadState.value = LoadState.EMPTY
                    }
                }

            }

        } catch (e: Exception) {
            loadState.value = LoadState.ERROR
            Log.e(TAG, e.message.toString())
        }
    }

    val loadState by lazy {
        MutableLiveData<LoadState>()
    }

    val contentData by lazy {
        MutableLiveData<ResultData<HomeBaseItem>>()
    }

}
