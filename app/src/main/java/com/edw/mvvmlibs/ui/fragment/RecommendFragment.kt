package com.edw.mvvmlibs.ui.fragment

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.adapter.HomePageAdapter
import com.edw.mvvmlibs.base.BaseRefreshFragment
import com.edw.mvvmlibs.broadcast.NetworkStatusReceiver
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.ui.activity.MainActivity
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.LoadState
import com.edw.mvvmlibs.viewmodel.RecommendViewModel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import org.koin.android.ext.android.inject


class RecommendFragment private constructor() :
    BaseRefreshFragment<HomeBaseItem, RecommendViewModel>(), NetworkStatusReceiver.CallBackNetwork {

    private val TAG = this.javaClass.simpleName

    private var canLoading: Boolean = true

    private var currentPage: Int = DEFAULT_PAGE

    private var isFirstPage: Boolean = true

    private object SingletonHolder {
        val holder by lazy { RecommendFragment() }
    }

    companion object {
        const val DEFAULT_PAGE: Int = 0

        fun getInstance() = SingletonHolder.holder
    }

    override fun getViewModelClazz(): Class<RecommendViewModel> {
        return RecommendViewModel::class.java
    }

    override fun startAdapter(): BaseProviderMultiAdapter<HomeBaseItem> {
        return HomePageAdapter()
    }


    override fun initEvent() {
        super.initEvent()
        mRefreshLayout.setOnRefreshListener(this::refreshData)
        mRefreshLayout.setOnLoadMoreListener(this::loadMoreData)
    }


    override fun observerData() {
        initHideView()
        vm!!.loadStatus.observe(this, {
            when (it) {
                LoadState.LOADING -> {
                    if (!mRefreshLayout.isRefreshing && canLoading) {
                        loadingView.visibility = View.VISIBLE
                        mRefreshLayout.visibility = View.GONE
                    }
                }

                LoadState.SUCCESS -> {
                    canLoading = false
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
                    mRefreshLayout.finishLoadMore(false)
                }

            }
        })

        vm!!.contentData.observe(this, {
            if (!TextUtils.isEmpty(it.nextPageUrl)) {
                mRefreshLayout.finishRefresh()
                mRefreshLayout.finishLoadMore()
                if (isFirstPage) {
                    mAdapter!!.data.clear()
                    mAdapter!!.setList(it.itemList)
                } else {
                    mAdapter!!.addData(it.itemList!!)
                }

                //http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=1&isTag=true&adIndex=5 截取Url第一个等号后面的参数(页码)
                currentPage = it.nextPageUrl!!.substringAfter("=").substring(0, 1).toInt()
                isFirstPage = currentPage == 0
                if (currentPage == 0) {
                    //当url中的页码回到0时直接结束更多加载
                    mRefreshLayout.finishLoadMoreWithNoMoreData()
                }
            } else {
                //更新失败
                mRefreshLayout.finishLoadMore(false)
            }
        })
    }

    /**
     * 下拉刷新数据
     */
    private fun refreshData(refreshLayout: RefreshLayout) {
        isFirstPage = true
        vm?.run { loadData(page = DEFAULT_PAGE) }

    }

    private fun loadMoreData(refreshLayout: RefreshLayout) {
        isFirstPage = false
        vm?.run { loadData(page = currentPage) }

    }

    override fun broadcastDataChange() {
        vm?.loadData(page = DEFAULT_PAGE)
    }


}