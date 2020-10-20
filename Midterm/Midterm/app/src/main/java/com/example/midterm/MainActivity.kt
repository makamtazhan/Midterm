package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), TaskListAdapter.ItemClickListener {
    private lateinit var taskListFragment: TaskListFragment
    private lateinit var taskDetailFragment: TaskDetailFragment
    private lateinit var addToDoFragment: AddToDoFragment
    private lateinit var fragmentManager: FragmentManager
    private var list = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..20) {
            list.add(
                Task(
                    i,
                    "Title$i",
                    "Description$i",
                    "incomplete",
                    "Education",
                    "3 days"
                )
            )
        }
        taskListFragment = TaskListFragment(list, this)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment, taskListFragment).commit()
    }

    override fun itemClicked(item: Task) {
        taskDetailFragment = TaskDetailFragment(item)
        fragmentManager.beginTransaction().replace(R.id.fragment, taskDetailFragment)
            .addToBackStack("tag").commit()
    }

    override fun addTaskButtonClicked() {
        addToDoFragment = AddToDoFragment(list.size, list)
        fragmentManager.beginTransaction().replace(R.id.fragment, addToDoFragment)
            .addToBackStack("addFragment").commit()
    }

}