package com.example.mailapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter(
    private val list: ArrayList<Mail>,
    private val context: Context,
    val listener: ItemClickListener
) :
    RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = list[position]
        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private val view: View, context: Context) :
        RecyclerView.ViewHolder(view) {

        fun bind(task: Mail) {
            val title: TextView = view.findViewById(R.id.title)
            val date: TextView = view.findViewById(R.id.date)
            val author: TextView = view.findViewById(R.id.author)
            title.text = task.title
            date.text = task.date
            author.text = task.author

            view.setOnClickListener {
                listener.itemClicked(task)
            }
        }
    }

    interface ItemClickListener {
        fun itemClicked(item: Mail)
    }

}