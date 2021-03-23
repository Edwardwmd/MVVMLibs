package com.edw.mvvmlibs.base

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.databinding.FragmentBaseRefreshBinding
import org.koin.androidx.viewmodel.compat.ViewModelCompat


abstract class BaseRefreshFragment<T, VM : ViewModel> :
    Fragment() {


    protected var vm: VM? = null

    protected lateinit var mAdapter: BaseProviderMultiAdapter<T>

    protected lateinit var binding: FragmentBaseRefreshBinding

    protected lateinit var mRecy: RecyclerView

    protected lateinit var mRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_base_refresh, container, false)
        return binding.root
    }

    /**
     * Android将对onActivityCreated弃用,使用onViewCreated代替onActivityCreated
     * 为了解决fragment与Activity之间的特殊耦合
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecy = binding.recyBase
        mRefreshLayout = binding.swipeRefresh

        initViewModel()

        initData()

        initAdapter()

        initRefresh()

        loadMoreData()

        observerData()

    }

    open fun initData() {}
    open fun observerData() {}

    private fun loadMoreData() {
        mAdapter.loadMoreModule.setOnLoadMoreListener {
            questData()
        }
        //自动加载更多
        mAdapter.loadMoreModule.isAutoLoadMore = true

        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        mAdapter.loadMoreModule.isEnableLoadMoreIfNotFullPage = false

    }

    private fun initAdapter() {
        mAdapter = startAdapter()
        mRecy.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mRecy.setHasFixedSize(true)
        mRecy.adapter = mAdapter
        mRecy.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //SCROLL_STATE_IDLE:表示停止滑动(空闲)的状态
                //SCROLL_STATE_DRAGGING:表示正在滑动状态
                //SCROLL_STATE_SETTLING:表示正在滑动。滑动后自然沉降的状态
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> Glide.with(this@BaseRefreshFragment)
                        .resumeRequests()
                    RecyclerView.SCROLL_STATE_DRAGGING -> Glide.with(this@BaseRefreshFragment)
                        .resumeRequests()
                    RecyclerView.SCROLL_STATE_SETTLING -> Glide.with(this@BaseRefreshFragment)
                        .pauseAllRequests()
                }

            }
        })

    }

    private fun initRefresh() {
        mRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189))
        mRefreshLayout.setOnRefreshListener {
            refreshData()
        }
    }


    open fun refreshData() {

        //这里的作用是防止下拉刷新的时候还可以上拉加载
        mAdapter.loadMoreModule.isEnableLoadMore = false
        //加载数据
        questData()
    }

    open fun questData() {}

    /**
     * 初始化Adapter
     */
    abstract fun startAdapter(): BaseProviderMultiAdapter<T>

    @SuppressLint("NewApi")
    private fun initViewModel() {
        //使用Koin依赖注入获取ViewModel
        vm = ViewModelCompat.getViewModel(this, getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>


    open fun initHideView() {
        binding.run {
//            loadingView.clLoading.visibility = View.GONE
//            errorView.clError.visibility = View.GONE
//            emptyView.clEmpty.visibility = View.GONE
//            disconnectNetworkView.clDisconnectNetwork.visibility = View.GONE
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        vm = null
    }

}