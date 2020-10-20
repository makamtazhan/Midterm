package com.example.midterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddToDoFragment(private val lastId: Int, var list: ArrayList<Task>) : Fragment() {
    private lateinit var id: TextView
    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var status: EditText
    private lateinit var category: EditText
    private lateinit var duration: EditText
    private lateinit var addTaskButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =
            inflater.inflate(R.layout.add_to_do_fragment, container, false) as ViewGroup
        id = rootView.findViewById(R.id.id)
        id.text = (lastId + 1).toString()
        title = rootView.findViewById(R.id.title)
        description = rootView.findViewById(R.id.description)
        status = rootView.findViewById(R.id.status)
        category = rootView.findViewById(R.id.category)
        duration = rootView.findViewById(R.id.duration)
        addTaskButton = rootView.findViewById(R.id.add_task)

        addTaskButton.setOnClickListener {
            val task = Task(
                lastId + 1,
                title.text.toString(),
                description.text.toString(),
                status.text.toString(),
                category.text.toString(),
                duration.text.toString()
            )
            list.add(task)
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}