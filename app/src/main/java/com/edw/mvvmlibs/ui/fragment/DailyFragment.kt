package com.edw.mvvmlibs.ui.fragment

import android.content.IntentFilter
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.adapter.HomePageAdapter
import com.edw.mvvmlibs.base.BaseRefreshFragment
import com.edw.mvvmlibs.base.BaseVmFragment
import com.edw.mvvmlibs.broadcast.NetworkStatusReceiver
import com.edw.mvvmlibs.databinding.FragmentDailyBinding
import com.edw.mvvmlibs.entity.HomeBaseItem
import com.edw.mvvmlibs.ui.activity.MainActivity
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.viewmodel.DailyViewModel
import org.koin.android.ext.android.inject


class DailyFragment private constructor() : BaseRefreshFragment<HomeBaseItem, DailyViewModel>(),
    NetworkStatusReceiver.CallBackNetwork {

    private object SingletonHolder {
        val holder by lazy {
            DailyFragment()
        }
    }

    companion object {
        fun getInstance() = SingletonHolder.holder

        const val DEFAULT_DATE = 1616851595678
        const val DEFAULT_NUM = 1
    }

    override fun getViewModelClazz(): Class<DailyViewModel> {
        return DailyViewModel::class.java
    }

    override fun startAdapter(): BaseProviderMultiAdapter<HomeBaseItem> {
        return HomePageAdapter()
    }

    override fun broadcastDataChange() {
        vm?.run {
            loadData(date = DEFAULT_DATE, num = DEFAULT_NUM)
        }
    }

}