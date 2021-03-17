package com.edw.mvvmlibs.ui.fragment

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentDailyBinding
import com.edw.mvvmlibs.viewmodel.DailyViewModel


class DailyFragment private constructor() : BaseVmFragment<FragmentDailyBinding, DailyViewModel>() {

    private object SingletonHolder {
        val holder = DailyFragment()
    }

    companion object {
        fun getInstance() = SingletonHolder.holder
    }

    override fun getViewModelClazz(): Class<DailyViewModel> {
        return DailyViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_daily
    }

}