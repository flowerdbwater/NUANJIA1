package com.example.nuanjia.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.Window
import android.view.WindowManager
import com.example.nuanjia.R

class WelcomeActivity : AppCompatActivity() {

    private val handler: Handler
        get() = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message?) {
                //实现页面的跳转
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)
                super.handleMessage(msg)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler.sendEmptyMessageDelayed(0,3000);

        // 隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_welcome)
    }
}