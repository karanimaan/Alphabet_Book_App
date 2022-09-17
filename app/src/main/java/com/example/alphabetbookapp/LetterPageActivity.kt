package com.example.alphabetbookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class LetterPageActivity : AppCompatActivity() {
    var letter = 'A'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_page)

        letter = intent.getCharExtra(EXTRA_LETTER, 'A')
        setImage(letter)

        /*val previousButton = findViewById<Button>(R.id.button2)
        previousButton.setOnClickListener(View.OnClickListener {
            val letter = previousButton.text[0] - 1
            setImage(letter)
        })*/
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
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}