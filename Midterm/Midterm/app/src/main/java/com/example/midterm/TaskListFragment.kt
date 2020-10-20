package com.example.midterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListFragment(
    private val list: ArrayList<Task>,
    private val listener: TaskListAdapter.ItemClickListener
) :
    Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var addTaskButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        taskListAdapter = TaskListAdapter(list, context!!, listener)
        val rootView = inflater.inflate(R.layout.task_list_fragment, container, false) as ViewGroup
        addTaskButton = rootView.findViewById(R.id.button)
        addTaskButton.setOnClickListener {
            listener.addTaskButtonClicked()
        }
        recyclerView = rootView.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = taskListAdapter
        return rootView
    }

}