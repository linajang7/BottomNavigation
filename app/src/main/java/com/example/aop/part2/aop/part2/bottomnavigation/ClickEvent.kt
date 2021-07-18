package com.example.aop.part2.aop.part2.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ClickEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_event)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}