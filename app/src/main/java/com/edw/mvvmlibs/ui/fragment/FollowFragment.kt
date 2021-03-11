package com.edw.mvvmlibs.ui.fragment


import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentFollowBinding
import com.edw.mvvmlibs.viewmodel.FollowViewModel

class FollowFragment : BaseVmFragment<FragmentFollowBinding, FollowViewModel>() {
    override fun getViewModelClazz(): Class<FollowViewModel> {
        return FollowViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_follow
    }

}