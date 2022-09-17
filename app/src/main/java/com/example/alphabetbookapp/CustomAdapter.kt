package com.example.alphabetbookapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>,
                    private val onItemClick: (letter: Char) -> Unit)
    : RecyclerView.Adapter<CustomAdapter.RecyclerViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // inflates the card_view_design view that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return RecyclerViewHolder(view, onItemClick)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class RecyclerViewHolder(rootView: View, private val onItemClick: (letter: Char) -> Unit)
        : RecyclerView.ViewHolder(rootView), View.OnClickListener {

        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val letter = textView.text[0]
            onItemClick(letter)
        }
    }
}