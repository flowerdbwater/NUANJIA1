package com.example.nuanjia.view.Square

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.nuanjia.R
import com.example.nuanjia.Tool
import com.example.nuanjia.view.DynamicAdapter
import kotlinx.android.synthetic.main.activity_my_dynamic.*
import kotlinx.android.synthetic.main.activity_publish.*


class PublishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_publish)
        val tool:Tool = Tool()
        tool.setWindowStatusBarColor(this,R.color.green)

        cancel.setOnClickListener {
            finish()
        }

        permission.setOnClickListener{
            val intent = Intent(this,PermissionActivity::class.java)
            startActivity(intent)
        }


    }

}