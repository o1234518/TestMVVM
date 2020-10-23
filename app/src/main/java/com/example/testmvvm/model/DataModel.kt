package com.example.testmvvm.model

import android.os.Handler

class DataModel {

    fun retrieveData(callback: onDataReadyCallBack) {
        Handler().postDelayed(Runnable { callback.onDataReady("New Data") }, 1500)
    }

    interface onDataReadyCallBack {
        fun onDataReady(data: String)
    }
}