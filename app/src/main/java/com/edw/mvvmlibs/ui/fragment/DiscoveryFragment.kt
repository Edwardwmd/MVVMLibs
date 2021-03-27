package com.edw.mvvmlibs.ui.fragment

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.view.View

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.adapter.HomePageAdapter
import com.edw.mvvmlibs.base.BaseRefreshFragment
import com.edw.mvvmlibs.broadcast.NetworkStatusReceiver
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.ui.activity.MainActivity
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.LoadState
import com.edw.mvvmlibs.viewmodel.DiscoveryViewModel
import org.koin.android.ext.android.inject

/**
 * Author: EdwardWMD
 * Data: 2021/3/22
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
class DiscoveryFragment : BaseRefreshFragment<HomeBaseItem, DiscoveryViewModel>() {

    //静态内部类单例获取DiscoveryFragment
    private object SingletonHolder {

        val holder by lazy { DiscoveryFragment() }
    }

    companion object {
        fun getInstance() = SingletonHolder.holder
    }


    override fun getViewModelClazz(): Class<DiscoveryViewModel> {
        return DiscoveryViewModel::class.java
    }

    override fun startAdapter(): BaseProviderMultiAdapter<HomeBaseItem> {
        return HomePageAdapter()
    }

    override fun initEvent() {
        super.initEvent()
        mRefreshLayout.setOnRefreshListener {
            vm?.run {
                loadData()
            }
        }
    }


    override fun observerData() {
        initHideView()
        vm!!.loadStatus.observe(this, {
            when (it) {
                LoadState.LOADING -> {
                    if (!mRefreshLayout.isRefreshing) {
                        loadingView.visibility = View.VISIBLE
                    }
                }
                LoadState.SUCCESS -> {
                    mRefreshLayout.finishRefresh()
                    mRefreshLayout.visibility = View.VISIBLE
                    initHideView()
                }
                LoadState.EMPTY -> {
                    emptyView.visibility = View.VISIBLE
                    mRefreshLayout.visibility = View.GONE
                }
                LoadState.ERROR -> {
                    errorView.visibility = View.VISIBLE
                    mRefreshLayout.visibility = View.GONE

                }

            }

        })

        vm!!.contentData.observe(this, {

            if (android.text.TextUtils.isEmpty(it.nextPageUrl)) {//判断下一页url内容是否为空
                mAdapter!!.setList(it.itemList!!)
                mAdapter!!.loadMoreModule.isEnableLoadMore = false
                if (!mAdapter!!.hasFooterLayout()) {
                    mAdapter!!.addFooterView(commonFooter())
                }
            }

        })
    }

    override fun broadcastDataChange() {
        vm?.run {
            loadData()
        }
    }
}