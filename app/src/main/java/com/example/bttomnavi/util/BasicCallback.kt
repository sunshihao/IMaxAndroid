package com.example.bttomnavi.util

import android.util.Log
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

/**
 * 一步步是爪牙
 * */

abstract class BasicCallback : AbstractCallback() {
    val TAG = BasicCallback::class.java.simpleName
    abstract fun succeed(call: Call?, result: String)

    override fun succeed(call: Call?, response: Response) {
        try {
            if (call!!.isCanceled()) {
                failed(call, IOException("Canceled!"))
                return
            }
            Log.e(TAG, "request:" + call.request().toString())
            Log.e(TAG, "response:" + response.toString())
            if (response.code !in 200..299) { // 返回Code不在200-299请求失败
                failed(call, IOException("request failed , reponse's code is : " + response.code))
                return
            }
            val str = response.body!!.string()
            Log.e(TAG, str)
            succeed(call, str)
        } catch (e: Exception) {
            Log.e(TAG, e.toString() + "")
            failed(call, e)
        } finally {
            if (response.body != null)
                response.body!!.close()
        }
    }

}