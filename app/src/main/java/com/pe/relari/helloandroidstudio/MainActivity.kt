package com.pe.relari.helloandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextReport = findViewById<Button>(R.id.button)
        val nextRegister = findViewById<Button>(R.id.button2)

        nextReport.setOnClickListener {
            startActivity(Intent(this, Report::class.java))
        }

        nextRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}
