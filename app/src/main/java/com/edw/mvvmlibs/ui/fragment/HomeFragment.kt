package com.edw.mvvmlibs.ui.fragment

import androidx.lifecycle.Observer
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentHomeBinding
import com.edw.mvvmlibs.viewmodel.HomeViewModel


class HomeFragment : BaseVmFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun getViewModelClazz(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun startLoadData() {
        vm.loadData()
    }

    override fun observeData() {
        //观察数据的变化
        vm.loadState.observe(this, Observer {
            //更新状态

        })

        vm.contentList.observe(this, Observer {
            //刷新数据

        })
    }
}