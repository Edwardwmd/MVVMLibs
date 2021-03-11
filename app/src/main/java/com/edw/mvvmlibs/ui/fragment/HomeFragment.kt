package com.edw.mvvmlibs.ui.fragment

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentHomeBinding
import com.edw.mvvmlibs.viewmodel.HomeViewModel


class HomeFragment : BaseVmFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun getViewModelClazz(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

}