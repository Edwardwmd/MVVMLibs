package com.edw.mvvmlibs.ui.fragment

import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.databinding.FragmentNotificationBinding
import com.edw.mvvmlibs.viewmodel.NotificationViewModel


class NotificationFragment : BaseVmFragment<FragmentNotificationBinding, NotificationViewModel>() {


    override fun getLayoutRes(): Int {
        return R.layout.fragment_notification
    }

    override fun getViewModelClazz(): Class<NotificationViewModel> {
        return NotificationViewModel::class.java
    }
}