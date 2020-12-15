package com.example.nuanjia.view.Square

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.nuanjia.R
import com.example.nuanjia.Tool

class AddBqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_add_b_q)

        val tool: Tool = Tool()
        tool.setWindowStatusBarColor(this,R.color.green)
    }
}