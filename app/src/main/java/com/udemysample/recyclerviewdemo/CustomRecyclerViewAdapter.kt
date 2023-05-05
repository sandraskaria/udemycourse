package com.udemysample.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R

class CustomRecyclerViewAdapter(
    private val fruits: List<Fruits>,
    private val doListener: (Fruits, View) -> Unit,
    private val getCompanyName: () -> String
) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.customadapter, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(fruits[position], doListener, getCompanyName)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

}

class CustomViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun bindData(fruits: Fruits, doListener: (Fruits, View) -> Unit, getCompanyName: () -> String) {
        val myText = itemView.findViewById<TextView>(R.id.item_text)
        val companyName = getCompanyName()
        val textVal = "$companyName - ${fruits.name}"
        myText.text = textVal
        itemView.setOnClickListener {
            doListener(fruits, itemView)
        }
    }

}