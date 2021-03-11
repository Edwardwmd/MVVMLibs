package com.edw.mvvmlibs.ui.fragment

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentMineBinding
import com.edw.mvvmlibs.viewmodel.MineViewModel


class MineFragment : BaseVmFragment<FragmentMineBinding, MineViewModel>() {
    override fun getViewModelClazz(): Class<MineViewModel> {
        return MineViewModel::class.java
    }

    override fun getLayoutRes(): Int {
       return R.layout.fragment_mine
    }
}