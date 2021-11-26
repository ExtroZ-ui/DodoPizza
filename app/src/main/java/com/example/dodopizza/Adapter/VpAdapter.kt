package com.example.dodopizza.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.R

class VpAdapter(val context:Context, val list:ArrayList<VpData>): RecyclerView.Adapter<VpAdapter.MyVH>() {
    class MyVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.vp_title)
        val descr: TextView = itemView.findViewById(R.id.vp_text)
        val image: ImageView = itemView.findViewById(R.id.vp_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.vp_fragment,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.title.text = list[position].descr
        holder.title.text = list[position].titel
        holder.image.setImageResource(list[position].imag)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}