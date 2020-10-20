package com.example.midterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class TaskListAdapter(
    private val list: ArrayList<Task>,
    private val context: Context,
    val listener: ItemClickListener
) :
    RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
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

        fun bind(task: Task) {
            val title: TextView = view.findViewById(R.id.title)
            val status: TextView = view.findViewById(R.id.status)
            val category: TextView = view.findViewById(R.id.category)
            title.text = task.title
            status.text = task.status
            category.text = task.category

            view.setOnClickListener {
                listener.itemClicked(task)
            }
        }
    }

    interface ItemClickListener {
        fun itemClicked(item: Task)
        fun addTaskButtonClicked()
    }

}