package com.example.nuanjia.view.Square

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.nuanjia.R
import com.example.nuanjia.Tool
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_permission)

        val tool: Tool = Tool()
        tool.setWindowStatusBarColor(this,R.color.green)

        btn_back.setOnClickListener {
            finish()
        }

        btn_ok.setOnClickListener {
            finish()
        }
    }
}