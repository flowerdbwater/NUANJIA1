package com.example.nuanjia.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nuanjia.R
import com.example.nuanjia.view.DynamicAdapter
import kotlinx.android.synthetic.main.activity_calendar.*
import kotlinx.android.synthetic.main.fragment_square.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }
}