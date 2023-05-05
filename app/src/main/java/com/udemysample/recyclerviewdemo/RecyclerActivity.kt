package com.udemysample.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R
import com.google.android.material.snackbar.Snackbar

class RecyclerActivity : AppCompatActivity() {
    private val fruits = listOf(Fruits("mango", "alex"),
        Fruits("apple", "shyam"), Fruits("orange", "frank"), Fruits("banana", "jack"),
        Fruits("guava", "james"), Fruits("cherry", "sean"), Fruits("grapes", "drake"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = CustomRecyclerViewAdapter(fruits,
            {selectedItem: Fruits, view: View -> doClickListener(selectedItem, view) },
            {getCompanyName()}
        )
    }

    fun doClickListener(selectedItem: Fruits, view: View) {
        Snackbar.make(view, "You clicked ${selectedItem.name}", Snackbar.LENGTH_LONG ).show()
    }

    fun getCompanyName(): String {
        return "S&S Co."
    }
}