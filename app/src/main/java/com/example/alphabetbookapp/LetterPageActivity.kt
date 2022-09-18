package com.example.alphabetbookapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

class LetterPageActivity : AppCompatActivity() {
    private var letter = 'A'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_page)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        letter = intent.getCharExtra(EXTRA_LETTER, 'A')
        setImage(letter)
    }

    private fun setImage(letter: Char) {
        if (letter in 'A'..'Z') {
            this.letter = letter
            val imageView = findViewById<ImageView>(R.id.imageView)
            val resID_A = resources.getIdentifier("slide01", "drawable", packageName)
            val resID = resID_A + ('A'..'Z').indexOf(letter)    // Assuming letter images are sequential
            imageView.setImageResource(resID)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun firstPage(view: View) {
        setImage('A')
    }


    fun previousPage(view: View) {
        setImage(letter - 1)
    }

    fun nextPage(view: View) {
        setImage(letter + 1)
    }

    fun lastPage(view: View) {
        setImage('Z')
    }

    fun overview(view: View) {
        finish()
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences("Alphabet", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("page", "LetterPageActivity")
        editor.putString("letter", letter.toString())
        editor.apply()
    }
}