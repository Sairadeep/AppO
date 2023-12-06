package com.anxer.appo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyCheckService : Service() {

    private var binder = object : IpAidlInterface.Stub(){
        override fun checkResult(name: String?, reverseName: String?): Boolean {
            return (name.equals(reverseName,ignoreCase = true))
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("serviceStatus","Service started.")
        return super.onStartCommand(intent, flags, startId)
    }
}