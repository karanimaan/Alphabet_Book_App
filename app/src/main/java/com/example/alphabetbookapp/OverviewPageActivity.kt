package com.example.alphabetbookapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val EXTRA_LETTER = "com.example.alphabetbookapp.LETTER"

class OverviewPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview_page)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 26 Views containing the letter of view
        for (c in 'A'..'Z') {
            data.add(ItemsViewModel(c.toString()))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data) { letter -> openLetterPage(letter) }

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        // load page
        val sharedPreferences = getSharedPreferences("Alphabet", Context.MODE_PRIVATE)
        val page = sharedPreferences.getString("page", "LetterPageActivity")
        val letter = sharedPreferences.getString("letter", "A")!!.toCharArray()[0]
        if (page == "LetterPageActivity") {
            openLetterPage(letter)
        }
    }

    private fun openLetterPage(letter: Char) {
        val intent = Intent(this, LetterPageActivity::class.java).apply {
            putExtra(EXTRA_LETTER, letter)
        }
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences("Alphabet", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("page", "OverviewPageActivity")
        editor.apply()
    }


}