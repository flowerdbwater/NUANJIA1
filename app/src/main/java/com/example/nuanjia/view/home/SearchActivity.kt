package com.example.nuanjia.view.home

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.nuanjia.R
import com.example.nuanjia.Tool


class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //去标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        //设置状态栏颜色
        val tool = Tool()
        tool.setWindowStatusBarColor(this,R.color.green)
        setContentView(R.layout.activity_search)

        initData()
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        //从数据库获取数据
        getDbData()

    }

    /**
     * 获取db 数据
     */
    private fun getDbData() {

    }
}