package com.example.cse225

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RatingActivity : AppCompatActivity() {

    private lateinit var msg:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ratingbar)
        val actionBar = supportActionBar

        actionBar!!.title = "Rate Us"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val simpleRatingBar:RatingBar = findViewById(R.id.simpleRatingBar)
        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {

            val totalStars = "Total Stars:: " + simpleRatingBar.numStars
            val rating = "Rating :: " + simpleRatingBar.rating
            val vg: ViewGroup?= findViewById(R.id.ll_wrapper)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.toastlayout,vg)
            // findViewById(R.id.custom_toast_layout1) as ViewGroup)
            val tv = layout.findViewById(R.id.toasttext) as TextView
            tv.text = """$totalStars$rating"""
            val toast = Toast(applicationContext)
            //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()
        }
        val aboutus = findViewById<ImageButton>(R.id.sendBtn)

        val msg = findViewById<TextView>(R.id.userMassage)
        aboutus.setOnClickListener {
            NotificationHelper(this,msg.text.toString()).Notification()
            val kh = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            kh.hideSoftInputFromWindow(currentFocus?.windowToken,0)
        }
    }
}