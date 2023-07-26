package com.deshaies.interview_us_bank.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deshaies.interview_us_bank.data.Data
import com.deshaies.interview_us_bank.R

class DataAdapter() : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private var data: List<Data> = emptyList()
    fun updateData(data: List<Data>){
        this.data = data
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val product = data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data: Data){
            itemView.findViewById<TextView>(R.id.title).text = data.symbol
            itemView.findViewById<TextView>(R.id.description).text = data.rateUsd
/*
            val image : ImageView =itemView.findViewById<ImageView>(R.id.image)

            Glide.with(itemView)
                .load(product.images[0])
                .into(image)

 */
        }
    }
}