package com.example.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View. OnClickListener{

    // get button
    var showBlBtn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBlBtn = findViewById(R.id.showBl)

        showBlBtn?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.showBl -> {
                // when button get pressed

            }
        }
    }
}