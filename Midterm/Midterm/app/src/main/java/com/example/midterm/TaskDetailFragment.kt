package com.example.midterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TaskDetailFragment(private val task: Task) :
    Fragment() {
    private lateinit var id: TextView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var status: TextView
    private lateinit var category: TextView
    private lateinit var duration: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =
            inflater.inflate(R.layout.task_detail_fragment, container, false) as ViewGroup
        id = rootView.findViewById(R.id.id)
        title = rootView.findViewById(R.id.title)
        description = rootView.findViewById(R.id.description)
        status = rootView.findViewById(R.id.status)
        category = rootView.findViewById(R.id.category)
        duration = rootView.findViewById(R.id.duration)

        id.text = task.id.toString()
        title.text = task.title
        description.text = task.description
        status.text = task.status
        category.text = task.category
        duration.text = task.duration
        return rootView
    }
}