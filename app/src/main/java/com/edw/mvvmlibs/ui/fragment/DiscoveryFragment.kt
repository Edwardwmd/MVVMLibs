package com.edw.mvvmlibs.ui.fragment


import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.DiscoveryAdapter
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentDiscoveryBinding
import com.edw.mvvmlibs.viewmodel.DiscoveryViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class DiscoveryFragment private constructor() :
    BaseVmFragment<FragmentDiscoveryBinding, DiscoveryViewModel>() {

    private val adapter: DiscoveryAdapter by inject()

    //静态内部类单例获取DiscoveryFragment
    private object SingletonHolder {
        val holder = DiscoveryFragment()
    }

    companion object {
        fun getInstance() = SingletonHolder.holder
    }

    override fun getViewModelClazz(): Class<DiscoveryViewModel> {
        return DiscoveryViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_discovery
    }

    override fun startLoadData() {
        //加载数据
        vm.loadData()
    }

    override fun observeData() {
        vm.loadState.observe(this, Observer {
            //更新状态
            binding.refresh.setOnRefreshListener {
                lifecycleScope.launch {

                }
            }

        })

        vm.contentData.observe(this, Observer {
            //更新数据
            if (it != null)
                adapter.setList(it.itemList)
        })
    }

    override fun initData() {
        binding.run {
            recyDiscovery.layoutManager = LinearLayoutManager(context)
            recyDiscovery.setHasFixedSize(true)
            recyDiscovery.adapter = adapter

        }
    }


}