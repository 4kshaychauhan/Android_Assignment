package com.example.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar)
        val actionBar = supportActionBar

        actionBar!!.title = "coustum toolbar"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}