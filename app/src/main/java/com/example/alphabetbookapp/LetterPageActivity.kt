package com.example.alphabetbookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LetterPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_page)

        val letter = intent.getStringExtra(EXTRA_LETTER)
    }
}