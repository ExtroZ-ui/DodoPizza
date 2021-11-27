package com.example.dodopizza.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dodopizza.R
import com.example.dodopizza.net.Quotes

data class QuoteAdapter(val context: Context, val quotes: ArrayList<Quotes.Data_quotes>): RecyclerView.Adapter<QuoteAdapter.MvQA>(){
    class MvQA(view: View): RecyclerView.ViewHolder(view){
        val titel: TextView = view.findViewById(R.id.title_text)
        val text: TextView = view.findViewById(R.id.dect_text)
        val im: ImageView = view.findViewById(R.id.image_quote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MvQA {
        return MvQA(LayoutInflater.from(context).inflate(R.layout.quote_fragment,null))
    }

    override fun onBindViewHolder(holder: MvQA, position: Int) {
        holder.titel.text = quotes[position].title
        holder.text.text = quotes[position].descript
        Glide.with(context).load(quotes[position].image).into(holder.im)
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

}
