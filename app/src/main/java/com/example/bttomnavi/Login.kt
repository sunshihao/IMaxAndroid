package com.example.bttomnavi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bttomnavi.util.JsonCallback
import com.example.bttomnavi.util.RequestManager
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProviders
//import com.example.bttomnavi.entity.User
//import com.example.bttomnavi.data.ProfileLiveDataViewModel
//import com.example.bttomnavi.databinding.LoginBinding
import com.example.bttomnavi.utils.CountDownTimerUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.Call
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap

/**
 * 用户登录
 * */
class Login : AppCompatActivity() {

    val URL = " 省略 "
    var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val btnLogin: Button = findViewById(R.id.btn_login)
        // kotlin进行页面跳转
        // 登录的各种路由行为的跳转 ？ android 自身有特别良好的防二次点击事件
        btnLogin.setOnClickListener{
//            Toast.makeText(applicationContext, "登录成功", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,MainActivity::class.java)
            sendRequest()
            startActivity(intent)
        }

        // 第一种绑定方式
        // 看看原来的数据双向绑定的用意，封装用意
        // 监听文本域内容 双向绑定数据 致此数据双向绑定的方向全部实现 ，但是感觉上这是一个淘汰的数据绑定模式 而且没有实现所谓的双向绑定 而且出现了
        // **
//        val viewModel = ViewModelProviders.of(this).get(ProfileLiveDataViewModel::class.java)
//        val binding: LoginBinding = DataBindingUtil.setContentView(this, R.layout.login) //
//        binding.viewmodel = viewModel
//        binding.lifecycleOwner = this
        // ***

        // 第二种绑定方式
//        val binding: LoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        val mMUser = User();
//        mMUser.setVercode("123123");
//        binding.setViewmodel(mMUser); // 感觉缺东西


        // 第三种绑定方式 宣告暂停任务

//        val binding: LoginBinding = DataBindingUtil.setContentView(
//            this, R.layout.login)
//
//        binding.viewmodel = User("Test", "User") // 你在视图的名字 靠谱
        initView() // 定时方案触发
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    // 倒计时
    fun initView(){
        var vercode: TextView = findViewById(R.id.code)
        vercode.setOnClickListener {
            // 首次的混合使用 java kotlin
            val mCountDownTimerUtils:CountDownTimerUtils = CountDownTimerUtils(vercode, 20000, 1000)
            mCountDownTimerUtils.start();
        }
    }

    fun sendRequest() {
//        val params = HashMap<String, String>()
//        params["key"] = "value"
        val params = null
        var url = "http://api.sit.jomoo.cn/imax/v1/jxlogin/sendVerificationCode/17615150217"
        var header = HashMap<String, String>()
        header["skipTokenAuthorize"] = "true"
        var requestManager: RequestManager  =  RequestManager()
        Log.d("ssssh","111111"); 
        requestManager.doGet(url,header,params).execute(object: JsonCallback<Any>(Any::class.java) {
            override fun succeed(call: Call?, data: Any) {
                // data就是返回对象了
                Log.d("ssssh",data.toString());
                Toast.makeText(applicationContext, data.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun failed(call: Call?, e: Exception?) {
            }

        })
    }


}