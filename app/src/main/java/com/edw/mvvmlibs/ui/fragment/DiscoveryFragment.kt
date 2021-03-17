package com.edw.mvvmlibs.ui.fragment


import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentDiscoveryBinding
import com.edw.mvvmlibs.viewmodel.DiscoveryViewModel

class DiscoveryFragment private constructor() :
    BaseVmFragment<FragmentDiscoveryBinding, DiscoveryViewModel>() {

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
        })

        vm.contentData.observe(this, Observer {
            //更新数据

        })
    }

    override fun initData() {
        binding.run {
            recyDiscovery.layoutManager = LinearLayoutManager(context)
            recyDiscovery.setHasFixedSize(true)

        }
    }


}