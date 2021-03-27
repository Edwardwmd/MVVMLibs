package com.edw.mvvmlibs.utils

import com.edw.mvvmlibs.ui.activity.LauncherActivity

/**
 * Author: EdwardWMD
 * Data: 2021/3/11
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 常量类
 */
object Constant {
    //1.ARouter跳转Activity or Fragment Path
    const val ACTIVITY_LAUNCHER = "/ui/activity/launcher_activity"
    const val ACTIVITY_MAIN = "/ui/activity/main_activity"


    //2.与数字相关的常量
    const val ANIM_DRUATION = 3000L

    //3.网络连接状态
    const val CONNECTING = "数据已连接"
    const val DISCONNECTED = "数据已断开连接"

    //4.Android Action
    const val CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"

}