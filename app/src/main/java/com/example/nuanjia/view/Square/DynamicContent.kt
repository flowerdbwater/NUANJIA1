package com.example.nuanjia.view.Square

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nuanjia.R
import com.example.nuanjia.view.CommentAdapter
import com.example.nuanjia.view.ContentAdapter
import com.example.nuanjia.view.MyFragment.SquareFragment
import kotlinx.android.synthetic.main.activity_dynamic_content.*

class DynamicContent : AppCompatActivity() {

    var comment:HashMap<String,Any> = HashMap()
    var list:ArrayList<HashMap<String,Any>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_dynamic_content)

        comment["profile"] = R.drawable.profile
        comment["name"] = "花露水"
        comment["tvContent"] = "妙啊！！！太妙了！！！"
        comment["time"] = "5:20"
        list.add(comment)

        comment["profile"] = R.drawable.profile
        comment["name"] = "花露水"
        comment["tvContent"] = "妙啊！！！太妙了！！！"
        comment["time"] = "5:20"
        list.add(comment)

        comment["profile"] = R.drawable.profile
        comment["name"] = "花露水"
        comment["tvContent"] = "妙啊！！！太妙了！！！"
        comment["time"] = "5:20"
        list.add(comment)

        comment["profile"] = R.drawable.profile
        comment["name"] = "花露水"
        comment["tvContent"] = "妙啊！！！太妙了！！！"
        comment["time"] = "5:20"
        list.add(comment)

        val manager = LinearLayoutManager(this)
        recyclerview.layoutManager = manager

        val adapter = ContentAdapter(list)
        recyclerview.adapter = adapter

        btn_back.setOnClickListener {
            finish()
        }
    }
}