package com.example.alphabetbookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createButtonGrid()
    }

    private fun createButtonGrid() {
        for (letter in 'A'..'Z') {
            
        }
    }
}