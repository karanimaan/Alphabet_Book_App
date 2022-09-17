package com.example.alphabetbookapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPreferences = getSharedPreferences("Alphabet", Context.MODE_PRIVATE)
        val page = sharedPreferences.getString("page", "LetterPageActivity")
        val letter = sharedPreferences.getString("letter", "A")?.toCharArray()?.get(0)
        if (page == "LetterPageActivity") {
            val intent = Intent(this, LetterPageActivity::class.java).apply {
                putExtra(EXTRA_LETTER, letter)
            }
            startActivity(intent)
        } else {
            startActivity(Intent(this, OverviewPageActivity::class.java))
        }

        super.onCreate(savedInstanceState)

    }

}