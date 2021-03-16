package com.edw.mvvmlibs.ui.activity

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.base.BaseVMActivity
import com.edw.mvvmlibs.databinding.ActivityMainBinding

import com.edw.mvvmlibs.ui.weight.FixFragmentNavigator
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.TimeUtils
import com.edw.mvvmlibs.utils.ToastUtils
import com.edw.mvvmlibs.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess


@Route(path = Constant.ACTIVITY_MAIN)
class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {

    lateinit var controller: NavController

    private val contrastTime=3000L

     private var mExitTime:Long=0

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    override fun observeData() {
        binding.apply {
            //通过Fragment管理器的Id查找到NavHostFragment
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            //获取导航控制器
            controller = navHostFragment.navController
            //初始化FixFragmentNavigator实例
            val fixFragmentNavigator =
                FixFragmentNavigator(this@MainActivity, supportFragmentManager, navHostFragment.id)
            //将fixFragmentNavigator添加到添加到导航托管中
            controller.navigatorProvider.addNavigator(fixFragmentNavigator)
            //通添加展示的fragment布局
            controller.setGraph(R.navigation.nav_mvvm_fragment)//手动添加
            //控制器与bottomNavigationView联动
            bottomNavigationView.setupWithNavController(controller)

//            bottomNavigationView.setupWithNavController(navHostFragment.navController)
        }


    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onBackPressed() {
//        如果调用 super.onBackPressed()，navigation会操作回退栈,切换到之前显示的页面，导致页面叠加错乱
//        super.onBackPressed()

        if (TimeUtils.currentTimes()-mExitTime>contrastTime){
           Snackbar.make(binding.root,"再按一次退出App",1200).show()
            mExitTime=TimeUtils.currentTimes()
        }else{
            exitProcess(0)
        }

    }

}