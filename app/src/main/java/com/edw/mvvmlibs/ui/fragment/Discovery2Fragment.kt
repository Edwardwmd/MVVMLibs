package com.edw.mvvmlibs.ui.fragment

import android.view.View
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.adapter.DiscoveryAdapter
import com.edw.mvvmlibs.base.BaseRefreshFragment
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.utils.LoadState
import com.edw.mvvmlibs.viewmodel.DiscoveryViewModel

/**
 * Author: EdwardWMD
 * Data: 2021/3/22
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
class Discovery2Fragment : BaseRefreshFragment<HomeBaseItem, DiscoveryViewModel>() {

    //静态内部类单例获取DiscoveryFragment
    private object SingletonHolder {
        val holder = Discovery2Fragment()
    }

    companion object {
        fun getInstance() = SingletonHolder.holder
    }


    override fun getViewModelClazz(): Class<DiscoveryViewModel> {
        return DiscoveryViewModel::class.java
    }

    override fun startAdapter(): BaseProviderMultiAdapter<HomeBaseItem> {
        return DiscoveryAdapter()
    }

    override fun initData() {
        vm?.run {
            loadData()
        }


    }

    override fun questData() {
        vm?.run {
            loadData()
        }

    }


    override fun observerData() {
        initHideView()
        vm!!.loadState.observe(this, {
            when (it) {
                LoadState.LOADING -> {
                    mRefreshLayout.isRefreshing = true

                }
                LoadState.SUCCESS -> {
                    mRefreshLayout.visibility = View.VISIBLE
                    mRefreshLayout.isRefreshing = false
                    initHideView()
                }
                LoadState.EMPTY -> {
//                    binding.emptyView.clEmpty.visibility = View.VISIBLE
                    mRefreshLayout.visibility = View.GONE
                }
                LoadState.ERROR -> {
//                    binding.errorView.clError.visibility = View.VISIBLE
                    mRefreshLayout.visibility = View.GONE
                }
                LoadState.NETWORKDISCONNECTED -> {
//                    binding.disconnectNetworkView.clDisconnectNetwork.visibility = View.VISIBLE
                    mRefreshLayout.visibility = View.GONE
                }
            }

        })

        vm!!.contentData.observe(this, {
            if (mAdapter.data.size < it.count) {
                //如果不够一页,显示没有更多数据布局
                mAdapter.loadMoreModule.loadMoreEnd()
            } else {
                mAdapter.loadMoreModule.loadMoreComplete()
            }
            mAdapter.setList(it.itemList)

        })
    }

}