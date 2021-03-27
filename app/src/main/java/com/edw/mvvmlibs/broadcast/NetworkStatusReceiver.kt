package com.edw.mvvmlibs.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.edw.mvvmlibs.net.client.NetworkStatusManager
import com.edw.mvvmlibs.utils.Constant
import com.edw.mvvmlibs.utils.Constant.CONNECTING
import com.edw.mvvmlibs.utils.Constant.DISCONNECTED

class NetworkStatusReceiver : BroadcastReceiver() {

    private var typeName: String = ""

    private var callBackNetwork: CallBackNetwork? = null


    override fun onReceive(context: Context, intent: Intent) {
       if (NetworkStatusManager.WIFI_CONNECTED or NetworkStatusManager.CELLPHONE_CONNECTED){
           typeName=CONNECTING  //有网络并连接
       }else if(!NetworkStatusManager.WIFI_CONNECTED and  !NetworkStatusManager.CELLPHONE_CONNECTED){
           typeName= DISCONNECTED //网络数据断开连接
       }

        callBackNetwork?.callBack(typeName)
    }

    fun setCallBackNetwork(callBackNetwork: CallBackNetwork) {
        this.callBackNetwork = callBackNetwork
    }

    interface CallBackNetwork {
        fun callBack(typeName: String?)
    }
}