package com.edw.mvvmlibs.ui.fragment

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentRecommendBinding
import com.edw.mvvmlibs.viewmodel.RecommendViewModel


class RecommendFragment private constructor() :
    BaseVmFragment<FragmentRecommendBinding, RecommendViewModel>() {
    private object SingletonHolder {
        val holder = RecommendFragment()
    }

    companion object {
        fun getInstance() = SingletonHolder.holder
    }

    override fun getViewModelClazz(): Class<RecommendViewModel> {
        return RecommendViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_recommend
    }

}