package com.edw.mvvmlibs.ui.activity

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVMActivity
import com.edw.mvvmlibs.databinding.ActivityMainBinding
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.viewmodel.MainViewModel


@Route(path = Constant.ACTIVITY_MAIN)
class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    override fun observeData() {
        super.observeData()
        binding.apply {
            //通过Fragment管理器的Id查找到NavHostFragment
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            bottomNavigationView.setupWithNavController(navHostFragment.navController)
        }
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


}