package com.example.bttomnavi.util

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import java.security.SecureRandom

import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 简单封装,这个文件是成功了但是缺乏火候
 * */
private class ZTrustManager : X509TrustManager {

//    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
//    }
//
//    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
//    }

    override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
        TODO("Not yet implemented")
    }

//    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
}

private val cookieStore by lazy {
    HashMap<HttpUrl?, List<Cookie>>()
}


// 就在这里实例化okhttp 其他的东西用到即可添加.用不到注释掉也无大碍.
private val mOkHttpClient by lazy {
    OkHttpClient().newBuilder().apply {
        this.connectTimeout(40, TimeUnit.SECONDS)
        this.readTimeout(40, TimeUnit.SECONDS)
        this.writeTimeout(40, TimeUnit.SECONDS)
        // 如果后台需要用到cookie 就加上就可以

        cookieJar(object : CookieJar {
            override fun loadForRequest(url: HttpUrl): List<Cookie> {
//                val cookies: List<Cookie>? =
//                        cookieStore.get(Params.url.toHttpUrlOrNull())
//                if (cookies == null) {
//                    // println("没加载到cookie")
//                }
//                return cookies ?: ArrayList()
                return ArrayList()

            }

            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                cookieStore.put(url, cookies)
//                cookieStore.put(Params.url.toHttpUrlOrNull(), cookies)
                /*for (cookie in cookies) {
                    println("guo cookice name:" + cookie.name)
                    println("guo cookece path:" + cookie.path)
                }*/
            }
        })
        ///
        val trustAllCerts: Array<TrustManager> = arrayOf(ZTrustManager())
        val sslContext: SSLContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())
        val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
        sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        hostnameVerifier(HostnameVerifier { _: String?, _: SSLSession? -> true })
    }.build()
}