package com.example.bttomnavi

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.bttomnavi.bean.User
import com.example.bttomnavi.data.ProfileLiveDataViewModel
import com.example.bttomnavi.databinding.ActivityMainBinding
import com.example.bttomnavi.databinding.LoginBinding
import com.example.bttomnavi.utils.CountDownTimerUtils


/**
 * 用户登录
 * */
class Login : AppCompatActivity() {

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.login)
//        val btnLogin: Button = findViewById(R.id.btn_login)
        // kotlin进行页面跳转
        // 登录的各种路由行为的跳转 ？ android 自身有特别良好的防二次点击事件
//        btnLogin.setOnClickListener{
//            Toast.makeText(applicationContext, "登录成功", Toast.LENGTH_SHORT).show()
//            val intent= Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }

        // 第一种绑定方式
        // 看看原来的数据双向绑定的用意，封装用意
        // 监听文本域内容 双向绑定数据 致此数据双向绑定的方向全部实现 ，但是感觉上这是一个淘汰的数据绑定模式 而且没有实现所谓的双向绑定 而且出现了
        // **
        val viewModel = ViewModelProviders.of(this).get(ProfileLiveDataViewModel::class.java)
        val binding: LoginBinding = DataBindingUtil.setContentView(this, R.layout.login)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        // ***

        // 第二种绑定方式
//        val binding: LoginBinding = DataBindingUtil.setContentView(this, R.layout.login)
//                val binding: LoginBinding = DataBindingUtil.setContentView(this, R.layout.login)
//
//        val mMUser = User()
//        mMUser.setPhone("1233333")
//        mMUser.setVerCode("张三")
//        binding.viewmodel = mMUser

        // 第三种绑定方式
        // **
        // DataBindingUtil.
//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
//                this, R.layout.login)
//
//// The returned binding has references to all the Views with an ID.
//        binding.observableFieldsActivityButton.setOnClickListener {
//            startActivity(Intent(this, ObservableFieldActivity::class.java))
//        }
//        binding.viewmodelActivityButton.setOnClickListener {
//            startActivity(Intent(this, ViewModelActivity::class.java))
//        }
//        val user = User("aaaa", "bbb")

//        dataBinding.user=User("aaaa","bbb")
//        dataBinding.setVariable(BR.user,user)
        // **


        // 视图绑定
//        binding = LoginBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)

        initView() // 定时方案触发
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


}