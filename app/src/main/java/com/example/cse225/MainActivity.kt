package com.example.cse225

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollable)

        val progressview = findViewById<ScrollView>(R.id.scrollView)
        val progressbar = findViewById<ProgressBar>(R.id.progressbar)
          progressview.setOnScrollChangeListener { v, _, scrollY, _, _ ->

              val totalScrollLength = progressview.getChildAt(0).height - progressview.height

              progressbar.apply {
                  max = totalScrollLength
                  progress = scrollY
              }
          }

        val actionBar = supportActionBar

        actionBar!!.title = "Android"

        val rateus = findViewById<ImageButton>(R.id.rateButton)

        rateus.setOnClickListener{
            val intent = Intent(this,RatingActivity::class.java)
            startActivity(intent)
        }

        // display Toast here...
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit -> finish()
        }
        return true
    }
}