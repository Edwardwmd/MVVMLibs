@file:Suppress("DEPRECATION")

package com.edw.mvvmlibs.net.client

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo

import android.net.wifi.WifiManager
import android.os.Build

import android.telephony.TelephonyManager
import com.edw.mvvmlibs.base.BaseApp

/**
 * Author: EdwardWMD
 * Data: 2021/3/13
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * 网络状态管理类
 */
@Suppress("DEPRECATION")
object NetworkStatusManager {

    enum class NetworkType {
        UNKNOWN,//未知
        DISCONNECTION,//未连接
        WIFI,//WIFI
        CELLULAR_2G,//2G网络
        CELLULAR_3G,//3G网络
        CELLULAR_4G,//4G网络
        CELLULAR_5G//5G网络
    }

    //连接活动管理器
    private val CONNECTIVITY_MANAGER: ConnectivityManager
        get() {
            return BaseApp.appContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        }

    //WIFI管理器
    private val WIFI_MANAGER: WifiManager
        @SuppressLint("WifiManagerLeak")
        get() {
            return BaseApp.appContext()
                .getSystemService(Context.WIFI_SERVICE) as WifiManager
        }

    //当前网络连接类型
    val NETWORK_CLASS: Int?
        get() {
            return if (WIFI_CONNECTED) return CONNECTIVITY_MANAGER.activeNetworkInfo!!.type else null
        }

    val NETWORK_CONNECTED: Boolean
        get() {
            if (Build.VERSION.SDK_INT >= 23) {
                //获取网络属性
                val networkCapabilities =
                    CONNECTIVITY_MANAGER.getNetworkCapabilities(CONNECTIVITY_MANAGER.activeNetwork)
                networkCapabilities?.apply {
                    return hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) or hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                }
            } else {
                val activeNetworkInfo = CONNECTIVITY_MANAGER.activeNetworkInfo
                activeNetworkInfo?.apply {
                    return isConnectedOrConnecting && activeNetworkInfo.state == NetworkInfo.State.CONNECTED
                }

            }
            return false
        }

    //当前WIFI是否可用
    val WIFI_CONNECTED: Boolean
        get() {

            if (Build.VERSION.SDK_INT >= 23) {
                //获取网络属性
                val networkCapabilities =
                    CONNECTIVITY_MANAGER.getNetworkCapabilities(CONNECTIVITY_MANAGER.activeNetwork)
                networkCapabilities?.apply {
                    return hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                }
            } else {
                val activeNetworkInfo = CONNECTIVITY_MANAGER.activeNetworkInfo
                activeNetworkInfo?.apply {
                    return isConnectedOrConnecting && type == ConnectivityManager.TYPE_WIFI
                }
            }
            return false
        }

    //手机网络
    val CELLULAR_ENABLE: Boolean
        get() {

            if (Build.VERSION.SDK_INT >= 23) {
                //获取网络属性
                val networkCapabilities =
                    CONNECTIVITY_MANAGER.getNetworkCapabilities(CONNECTIVITY_MANAGER.activeNetwork)
                networkCapabilities?.apply {
                    return hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                }
            } else {
                val activeNetworkInfo = CONNECTIVITY_MANAGER.activeNetworkInfo
                activeNetworkInfo?.apply {
                    return state == NetworkInfo.State.CONNECTED
                }
            }
            return false
        }

    //判断WIFI开关是否打开
    val WIFI_ENABLE: Boolean
        get() {
            return WIFI_MANAGER.isWifiEnabled
        }

    //打开或关闭WIFI
    fun setWiFiEnable(enable: Boolean) {
        when (enable) {
            true -> if (!WIFI_ENABLE) WIFI_MANAGER.isWifiEnabled = true

            false -> if (WIFI_ENABLE) WIFI_MANAGER.isWifiEnabled = false
        }
    }


    //网络连接类型
    val NETWORK_TYPE: NetworkType
        get() {
            if (WIFI_CONNECTED) return NetworkType.WIFI
            return when (NETWORK_CLASS) {
                TelephonyManager.NETWORK_TYPE_GPRS,
                TelephonyManager.NETWORK_TYPE_EDGE,
                TelephonyManager.NETWORK_TYPE_CDMA,
                TelephonyManager.NETWORK_TYPE_1xRTT,
                TelephonyManager.NETWORK_TYPE_IDEN -> {
                    NetworkType.CELLULAR_2G
                }
                TelephonyManager.NETWORK_TYPE_TD_SCDMA,
                TelephonyManager.NETWORK_TYPE_UMTS,
                TelephonyManager.NETWORK_TYPE_EVDO_0,
                TelephonyManager.NETWORK_TYPE_EVDO_A,
                TelephonyManager.NETWORK_TYPE_EVDO_B,
                TelephonyManager.NETWORK_TYPE_HSDPA,
                TelephonyManager.NETWORK_TYPE_HSPA,
                TelephonyManager.NETWORK_TYPE_HSUPA,
                TelephonyManager.NETWORK_TYPE_HSPAP,
                TelephonyManager.NETWORK_TYPE_EHRPD -> {
                    NetworkType.CELLULAR_3G
                }
                TelephonyManager.NETWORK_TYPE_LTE -> {
                    NetworkType.CELLULAR_4G
                }
                TelephonyManager.NETWORK_TYPE_NR -> {
                    NetworkType.CELLULAR_5G
                }

                TelephonyManager.DATA_DISCONNECTED -> {
                    NetworkType.DISCONNECTION
                }


                else -> NetworkType.UNKNOWN
            }

        }


}
