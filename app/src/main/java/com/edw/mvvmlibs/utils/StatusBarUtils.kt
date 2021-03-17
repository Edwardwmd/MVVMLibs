package com.edw.mvvmlibs.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager


/**
 * Author: EdwardWMD
 * Data: 2021/3/10
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: 沉浸式状态栏
 */
object StatusBarUtils {

    /**
     * 1.沉浸式状态栏SDK_INT>23 Android M
     */
    @Suppress("DEPRECATION")
    fun fixSystemBar(mActivity: Activity) {
        if (SDK_INT < Build.VERSION_CODES.M) return
        //获取手机整个屏幕视窗
        val window = mActivity.window
        //获取最顶端视图
        val decorView = window.decorView
        if (SDK_INT >= Build.VERSION_CODES.R) {//大于Android 11 (30)
            val controller = mActivity.window.insetsController
            controller?.apply {
                hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars() or WindowInsets.Type.systemBars())
                systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE //当下拉或上拉页面会显示状态栏
            }
        } else {//大于或等于Android 6 (23) 且小于Android 11 (30)
            decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE
                    )
            //指示此Window负责绘制系统栏背景的标志。如果设置，系统栏将以透明背景绘制
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //清楚半透明的状态栏，并提供最少的系统提供的背景保护
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //设置颜色为透明
            window.statusBarColor = Color.TRANSPARENT
        }
    }

}