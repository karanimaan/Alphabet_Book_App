package com.example.alphabetbookapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val adapter = CustomAdapter(data) { letter -> onItemClick(letter) }

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


    }

    private fun onItemClick(letter: String) {
        Toast.makeText(this, letter, Toast.LENGTH_SHORT).show()
    }


}