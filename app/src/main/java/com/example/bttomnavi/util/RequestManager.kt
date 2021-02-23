package com.example.bttomnavi.util

import okhttp3.*
import java.io.IOException

class RequestManager {

    var okHttpClient: OkHttpClient? = null
    var builder: Request.Builder? = null

    init {
        builder = Request.Builder()
    }

    constructor() {
        okHttpClient = HttpManager.instace().httpClient
    }

    constructor(okHttpClient: OkHttpClient?) {
        if (okHttpClient == null)
            RequestManager()
        else
            this.okHttpClient = okHttpClient
    }

    fun doGet(url: String, headers: HashMap<String, String>? = null, params: HashMap<String, String>? = null): RequestManager {
        if (url.isBlank())
            return this
        if (headers != null)
            addHeaders(headers)
        builder!!.url(if (params != null) setGetParams(url, params) else url).get()
        return this
    }

    fun doPost(url: String, headers: HashMap<String, String>? = null, params: HashMap<String, String>? = null): RequestManager {
        if (url.isBlank())
            return this
        if (headers != null)
            addHeaders(headers)
        builder!!.url(url)
        setPostParams(params)?.let { builder!!.post(it) }
        return this
    }

    fun addHeaders(headers: HashMap<String, String>) {
        headers.entries.forEach { entry ->
            headers.keys
            builder?.addHeader(entry.key, entry.value)
        }
    }

    fun setGetParams(url: String, params: HashMap<String, String>): String {
        var sb = StringBuilder(url)
        if (params.isNotEmpty()) sb.append("?") else sb
        params.forEach { entry ->
            params.keys
            sb.append(entry.key + "=" + entry.value + "&")
        }
        return if (sb.toString().endsWith("&")) sb.subSequence(0, sb.lastIndex).toString() else sb.toString()
    }

    fun setPostParams(params: HashMap<String, String>?): RequestBody? {
        var builder = FormBody.Builder()
        params?.forEach { entry ->
            params.keys
            builder.add(entry.key, entry.value)
        }
        return builder.build()
    }

    fun execute(abstractCallback: AbstractCallback) {
        okHttpClient!!.newCall(builder!!.build()).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                abstractCallback.succeed(call, response)
            }

            override fun onFailure(call: Call, e: IOException) {
                abstractCallback.failed(call, e)
            }
        })
    }
}