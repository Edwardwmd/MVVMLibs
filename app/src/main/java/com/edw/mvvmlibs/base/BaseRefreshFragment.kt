package com.edw.mvvmlibs.base

import android.annotation.SuppressLint
import android.content.IntentFilter
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

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.broadcast.NetworkStatusReceiver
import com.edw.mvvmlibs.databinding.FragmentBaseRefreshBinding
import com.edw.mvvmlibs.ui.activity.MainActivity
import com.edw.mvvmlibs.utils.Constant
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.compat.ViewModelCompat


abstract class BaseRefreshFragment<T, VM : ViewModel> :
    Fragment(), NetworkStatusReceiver.CallBackNetwork {


    protected var vm: VM? = null

    protected var mAdapter: BaseProviderMultiAdapter<T>? = null

    protected lateinit var binding: FragmentBaseRefreshBinding

    private lateinit var mRecy: RecyclerView

    protected lateinit var mRefreshLayout: SmartRefreshLayout

    protected lateinit var emptyView: View

    protected lateinit var disconnectNetworkView: View

    protected lateinit var errorView: View

    protected lateinit var loadingView: View

    private val receiver by inject<NetworkStatusReceiver>()

    private val intentFilter by inject<IntentFilter>()


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
        initView()

        initAdapter()

        initViewModel()

        initData()

        observerData()

        initEvent()
    }


    open fun observerData() {}

    private fun initView() {
        mRecy = binding.recyBase
        mRefreshLayout = binding.swipeRefresh
        loadingView = binding.loadingView.clLoading
        emptyView = binding.emptyView.clEmpty
        disconnectNetworkView = binding.disconnectNetworkView.clDisconnectNetwork
        errorView = binding.errorView.clError
        mRefreshLayout.setEnableAutoLoadMore(true)
        mRefreshLayout.setRefreshFooter(ClassicsFooter(activity))


    }

    open fun initData() {
        intentFilter.addAction(Constant.CONNECTIVITY_CHANGE)
        (activity as MainActivity).registerReceiver(receiver, intentFilter)
        receiver.setCallBackNetwork(this)
    }

    open fun initEvent() {
        binding.disconnectNetworkView.ivDisconnectNetwork.setOnClickListener {
            binding.disconnectNetworkView.tvDisconnectNetwork.text = "请打开网络哟 ^V^"
        }
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


    @SuppressLint("NewApi")
    private fun initViewModel() {
        //使用Koin依赖注入获取ViewModel
        vm = ViewModelCompat.getViewModel(this, getViewModelClazz())
    }

    abstract fun getViewModelClazz(): Class<VM>

    /**
     * 隐藏状态
     */
    open fun initHideView() {
        loadingView.visibility = View.GONE
        errorView.visibility = View.GONE
        emptyView.visibility = View.GONE
        emptyView.visibility = View.GONE
    }

    open fun commonFooter(): View {
        return layoutInflater.inflate(R.layout.item_commom_footer, mRecy, false)
    }

    override fun callBack(typeName: String?) {
        if (Constant.CONNECTING == typeName) {
            broadcastDataChange()
            disconnectNetworkView.visibility = View.GONE
            binding.disconnectNetworkView.tvDisconnectNetwork.text = "网络断开连接咯 !-_-!"
        } else {
            disconnectNetworkView.visibility = View.VISIBLE
            mRefreshLayout.visibility = View.GONE
        }
    }

    /**
     * 初始化Adapter
     */
    abstract fun startAdapter(): BaseProviderMultiAdapter<T>

    /**
     * 通过广播实时监听网络是否连接,连接后加载数据
     */
    abstract fun broadcastDataChange()


    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        vm = null
        mAdapter!!.data.clear()
        mAdapter = null
        (activity as MainActivity).unregisterReceiver(receiver)
    }

}