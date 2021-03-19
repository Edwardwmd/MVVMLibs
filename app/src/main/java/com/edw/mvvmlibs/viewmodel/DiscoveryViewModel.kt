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
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    val discovery: ResultData<HomeBaseItem>?
                    val itemList: MutableList<HomeBaseItem>?
                    discovery = repository.discovery()
                    itemList = discovery.itemList
                    if (itemList!!.size > 0) {
                        withContext(Dispatchers.Main) {
                            contentData.value = itemList
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
        } else {
            loadState.value = LoadState.NETWORKDISCONNECTED
        }


    }

    val loadState by lazy {
        MutableLiveData<LoadState>()
    }

    val contentData by lazy {
        MutableLiveData<MutableList<HomeBaseItem>>()
    }

}
